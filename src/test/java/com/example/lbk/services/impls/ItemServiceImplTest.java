package com.example.lbk.services.impls;

import com.example.lbk.model.Item;
import com.example.lbk.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/*
  @author   george
  @project   lbk
  @class  ItemServiceImplTest
  @version  1.0.0 
  @since 03.05.2021 - 20.28
*/

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {
    @Mock private ItemRepository repository;
    private ItemServiceImpl serviceUnderTest;


    @BeforeEach
    void setUp() {
      serviceUnderTest = new ItemServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    @Disabled
    void get() {
    }

    @Test
    void create() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        Item item = new Item("11", "item11", "desc11", now, null);

        serviceUnderTest.create(item);

        ArgumentCaptor<Item> argumentCaptor = ArgumentCaptor.forClass(Item.class);

        verify(repository).save(argumentCaptor.capture());

        Item itemCaptured = argumentCaptor.getValue();
        assertEquals(item, itemCaptured);

    }

    @Test
    void throwWhenNameisNull() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        Item item = new Item("11", "item11", "desc11", now, null);

        given(repository.findByNameExists(anyString()))
                .willReturn(true);

        assertThatThrownBy(() -> serviceUnderTest.create(item))
        .isInstanceOf(Exception.class)
                .hasMessageContaining("Name is occupied");

        verify(repository, never()).save(any());
    }

    @Test
    void getAll() {
        serviceUnderTest.getAll();
        verify(repository).findAll();
    }
}

package com.example.lbk.repository;

import com.example.lbk.model.Item;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author   george
  @project   lbk
  @class  ItemRepositoryTest
  @version  1.0.0 
  @since 03.05.2021 - 15.58
*/

class ItemRepositoryTest {

    @Autowired
    ItemRepository underTest;

    @Test
    void getByDesc() {
        // given
        Item item = new Item("11",
                "item11",
                "desc11",
                LocalDateTime.now(),
                null);
        //
        underTest.save(item);
        // when
        String actualName = underTest.findFirstByDescription("desc11").getName();
        // then
        assertEquals("desc11",actualName);

    }
}

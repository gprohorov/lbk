package com.example.lbk.repository;

import com.example.lbk.model.Item;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author   george
  @project   lbk
  @class  ItemRepositoryTest
  @version  1.0.0 
  @since 03.05.2021 - 15.58
*/

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ItemRepositoryTest {

    @Autowired
    ItemRepository underTest;


    @BeforeEach
    public void setUp() {
        Item item1 = new Item("11",
                "item11",
                "desc11",
                LocalDateTime.now(),
                null);
        Item item2 = new Item("12",
                "item12",
                "desc12",
                LocalDateTime.now(),
                null);
        Item item3 = new Item("13",
                "item13",
                "desc13",
                LocalDateTime.now(),
                LocalDateTime.now());
        //
        underTest.save(item1);
        underTest.save(item2);
        underTest.save(item3);
    }

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void getByDesc() {

        String actualName = underTest.findFirstByDescription("desc11").getName();
        // then
        assertEquals("item11",actualName);
    }


    @Test
    void findAllByUpdatedAtExists() {
        String name = underTest.findAllByUpdatedAtNotNull().get(0).getName();
        assertEquals("item13",name);
    }
}

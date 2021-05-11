package com.example.lbk.controller;
/*
  @author   george
  @project   lbk
  @class  ItemController
  @version  1.0.0 
  @since 27.04.2021 - 16.34
*/

import com.example.lbk.model.Item;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private List<Item> items = Stream.of(
            new Item("1","Item1", "desc1", LocalDateTime.now(), null),
            new Item("2","Item2", "desc2", LocalDateTime.now(), null),
            new Item("3","Item2", "desc3", LocalDateTime.now(), null)
    ).collect(Collectors.toList());


    @RequestMapping("/getall")
    List<Item> getAll(){
        return items;
    }

    @PostMapping("/create")
    Item  createItem(@RequestBody Item item){
         item.setCreatedAt(LocalDateTime.now());
        return item;
    }


}

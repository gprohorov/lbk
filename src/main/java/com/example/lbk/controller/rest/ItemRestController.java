package com.example.lbk.controller.rest;
/*
  @author   george
  @project   lbk
  @class  ItemController
  @version  1.0.0 
  @since 27.04.2021 - 16.34
*/

import com.example.lbk.model.Item;
import com.example.lbk.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/items")
public class ItemRestController {

    @Autowired
    ItemServiceImpl service;

    @RequestMapping("/getall")
    List<Item> getAll(){
        return service.getAll();

    }

    @RequestMapping("/getone")
    Item getOne(){

        return service.getAll().get(0);
    }
    @PostMapping("/create")
    Item create(@RequestBody Item item){
        item.setCreatedAt(LocalDateTime.now());

        return service.create(item);
    }


}

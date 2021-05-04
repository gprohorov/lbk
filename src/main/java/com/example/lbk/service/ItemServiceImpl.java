package com.example.lbk.service;
/*
  @author   george
  @project   lbk
  @class  ItemServiceImpl
  @version  1.0.0 
  @since 04.05.2021 - 15.41
*/

import com.example.lbk.model.Item;
import com.example.lbk.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemServiceImpl {

    @Autowired
    ItemRepository repository;

    public List<Item> getAll(){
        return repository.findAll();
    }
    public Item create(Item item){
        item.setCreatedAt(LocalDateTime.now());
        return repository.save(item);
    }

}

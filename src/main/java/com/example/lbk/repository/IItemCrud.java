package com.example.lbk.repository;
/*
  @author   george
  @project   lbk
  @class  IItemCrud
  @version  1.0.0 
  @since 03.05.2021 - 15.45
*/

import com.example.lbk.model.Item;

import java.util.List;

public interface IItemCrud {
    Item get(String id);
    Item create(Item item);
    Item update(Item item);
    Item delete(String id);
    List<Item> getAll();

}

package com.example.lbk.services.interfaces;
/*
  @author   george
  @project   lbk
  @class  IStudentService
  @version  1.0.0 
  @since 03.05.2021 - 12.48
*/

import com.example.lbk.model.Item;

import java.util.List;

public interface IItemService {
    Item get(String id);
    Item create(Item item);
    Item update(Item item);
    Item delete(String id);
    List<Item> getAll();


}

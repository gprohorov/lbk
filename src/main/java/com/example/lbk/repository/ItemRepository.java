package com.example.lbk.repository;
/*
  @author   george
  @project   lbk
  @class  ItemRepository
  @version  1.0.0 
  @since 03.05.2021 - 12.53
*/

import com.example.lbk.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>, IItemCrud {
    Item findFirstByDescription(String  description);
    List<Item> findAllByUpdatedAtExists();

}

package com.example.lbk.repository;

import com.example.lbk.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
  @author   george
  @project   lbk
  @class  ItemRepository
  @version  1.0.0 
  @since 04.05.2021 - 15.37
*/
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

}

package com.example.lbk.services.impls;
/*
  @author   george
  @project   lbk
  @class  IItemServiceImpl
  @version  1.0.0 
  @since 03.05.2021 - 12.51
*/

import com.example.lbk.model.Item;
import com.example.lbk.repository.ItemRepository;
import com.example.lbk.services.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ItemServiceImpl implements IItemService {

    private List<Item> items = Stream.of(
            new Item("1","Item1", "desc1", LocalDateTime.now().plusHours(3), null),
            new Item("2","Item2", "desc2", LocalDateTime.now().plusHours(3), null),
            new Item("3","Item2", "desc3", LocalDateTime.now().plusHours(3), null)
    ).collect(Collectors.toList());

    @Autowired
    ItemRepository repository;

    @PostConstruct
    void init(){
        repository.saveAll(items);
    }

    @Override
    public Item get(String id) {
        return null;
    }

    @Override
    public Item create(Item item) {
        return null;
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public Item delete(String id) {
        return null;
    }

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }
}

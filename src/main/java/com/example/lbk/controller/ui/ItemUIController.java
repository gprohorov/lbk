package com.example.lbk.controller.ui;
/*
  @author   george
  @project   lbk
  @class  ItemController
  @version  1.0.0 
  @since 27.04.2021 - 16.34
*/

import com.example.lbk.form.ItemCreateForm;
import com.example.lbk.model.Item;
import com.example.lbk.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/ui/items")
public class ItemUIController {

    @Autowired
    ItemServiceImpl service;

    @RequestMapping("/getall")
    String getAll(Model model){
      model.addAttribute("items",service.getAll() );
        return "items";
    }

    @GetMapping("/create")
    String create(Model model){
        model.addAttribute("itemform", new ItemCreateForm());
        return "itemcreate";
    }

    @PostMapping("/create")
    String create(@ModelAttribute("itemform") ItemCreateForm form){
        Item item = new Item();
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.create(item);
        return "redirect:ui/items/getall";
    }


}

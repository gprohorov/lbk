package com.example.lbk.controller.ui;

import com.example.lbk.model.Item;
import com.example.lbk.service.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author   george
  @project   lbk
  @class  ItemUIControllerTest
  @version  1.0.0 
  @since 05.05.2021 - 12.08
*/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ItemUIControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ItemServiceImpl service;

    @Test
    void getAllTestUI() throws Exception {
        List<Item> expected = service.getAll();
        mockMvc.perform(MockMvcRequestBuilders.get("/ui/items/getall"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("items"))
                .andExpect(MockMvcResultMatchers.model().attribute("items", expected));
    }


    @Test
    void createPostTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/ui/items/create")
                .param("name", "testing")
                .param("description", "desc- testing")
        )
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}

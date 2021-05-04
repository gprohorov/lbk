package com.example.lbk.model;
/*
  @author   george
  @project   lbk
  @class  Item
  @version  1.0.0 
  @since 27.04.2021 - 16.19
*/

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Item {
    @Id
    private String id;
    private  String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Item(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

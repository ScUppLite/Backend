package com.scupp.scupplite.dto.category;

import com.scupp.scupplite.entities.Category;


public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

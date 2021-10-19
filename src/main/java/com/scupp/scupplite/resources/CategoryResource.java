package com.scupp.scupplite.resources;


import com.scupp.scupplite.dto.category.CategoryDTO;
import com.scupp.scupplite.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @PostMapping(value = "/save")
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.save(dto));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }



}

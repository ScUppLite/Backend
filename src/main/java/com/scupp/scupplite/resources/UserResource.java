package com.scupp.scupplite.resources;


import com.scupp.scupplite.dto.category.CategoryDTO;
import com.scupp.scupplite.dto.user.UserDTO;
import com.scupp.scupplite.dto.user.UserInsertDTO;
import com.scupp.scupplite.dto.user.UserRegisterDTO;
import com.scupp.scupplite.services.CategoryService;
import com.scupp.scupplite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping(value = "/save")
    public ResponseEntity<UserDTO> save(@RequestBody UserRegisterDTO dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }




}

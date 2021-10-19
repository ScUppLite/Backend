package com.scupp.scupplite.services;

import com.scupp.scupplite.dto.category.CategoryDTO;
import com.scupp.scupplite.dto.user.UserDTO;
import com.scupp.scupplite.dto.user.UserInsertDTO;
import com.scupp.scupplite.dto.user.UserRegisterDTO;
import com.scupp.scupplite.entities.Category;
import com.scupp.scupplite.entities.User;
import com.scupp.scupplite.repositories.CategoryRepository;
import com.scupp.scupplite.repositories.UserRepository;
import com.scupp.scupplite.util.UserCategoriesValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Transactional
    public UserDTO save(UserRegisterDTO dto) {
        User entity = new User();
        copyDtoToEntity(entity, dto);
        UserCategoriesValidation.validation(entity);
        repository.save(entity);
        return new UserDTO(entity,entity.getCategories());
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        return repository.findAll().stream().map(x-> new UserDTO(x,x.getCategories())).collect(Collectors.toList());
    }

    // Auxiliary Methods
    private User copyDtoToEntity(User entity, UserRegisterDTO dto) {
        entity.setAlone(Boolean.TRUE);
        entity.setUsername(dto.getUsername());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setCpf(dto.getCpf());
        entity.setPhone(dto.getPhone());
        entity.setBirthDate(dto.getBirthDate());
        entity.setEmail(dto.getEmail());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.getCategories().clear();
        for (CategoryDTO dtoCat : dto.getCategories()) {
            Category cat = categoryRepository.getOne(dtoCat.getId());
            entity.getCategories().add(cat);
        }
        return entity;
    }
}

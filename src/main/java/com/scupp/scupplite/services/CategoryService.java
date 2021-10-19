package com.scupp.scupplite.services;

import com.scupp.scupplite.dto.category.CategoryDTO;
import com.scupp.scupplite.entities.Category;
import com.scupp.scupplite.repositories.CategoryRepository;
import com.scupp.scupplite.services.exceptions.DatabaseException;
import com.scupp.scupplite.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public CategoryDTO save(CategoryDTO dto) {
        Category entity = new Category();
        return new CategoryDTO(repository.save(copyDtoToEntity(entity, dto)));
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {

            Category entity = auxiliaryUpdate(id, dto);
            repository.save(entity);
            return new CategoryDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found : " + id);
        }
    }


    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        return repository.findAll().stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        return repository.findById(id).map(CategoryDTO::new).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }


    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database Integrity Violation");
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found : " + id);
        }
    }

    // Auxiliary methods

    private Category copyDtoToEntity(Category entity, CategoryDTO dto) {
        entity.setName(dto.getName().toUpperCase());
        return entity;
    }

    private Category auxiliaryUpdate(Long id, CategoryDTO dto) {
        Category category = repository.getOne(id);
        category.setName(dto.getName().toUpperCase());
        return category;
    }

}

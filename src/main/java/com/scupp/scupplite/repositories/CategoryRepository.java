package com.scupp.scupplite.repositories;

import com.scupp.scupplite.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

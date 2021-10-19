package com.scupp.scupplite.repositories;

import com.scupp.scupplite.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

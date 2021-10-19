package com.scupp.scupplite.entities;

import java.lang.String;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @ManyToMany(mappedBy = "categories")
    private Set<User> users = new HashSet<>();

    public Category() {
    }

    public Category(Long id, String name, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Set<User> getUsers() {
        return users;
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

    public Instant getCreated_At() {
        return createdAt;
    }

    public Instant getUpdated_At() {
        return updatedAt;
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }
}

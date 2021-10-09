package com.scupp.scupplite.entities;

import java.lang.String;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant created_At;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updated_At;

    public Category() {
    }

    public Category(Long id, String name, Instant created_At, Instant updated_At) {
        this.id = id;
        this.name = name;
        this.created_At = created_At;
        this.updated_At = updated_At;
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
        return created_At;
    }

    public Instant getUpdated_At() {
        return updated_At;
    }

    @PrePersist
    public void prePersist() {
        created_At = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated_At = Instant.now();
    }
}

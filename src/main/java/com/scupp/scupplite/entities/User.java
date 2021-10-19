package com.scupp.scupplite.entities;


import lombok.Getter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private LocalDate birthDate;
    @Column(columnDefinition = "TEXT")
    private String imgUrl;
    private Boolean isAlone;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;
    @ManyToMany
    @JoinTable(name = "tb_user_category"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public User() {
    }

    public User(Long id, String username, String firstName, String lastName, String email
            , String password, String cpf, String phone, LocalDate birthDate,
            String imgUrl, Boolean isAlone, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.birthDate = birthDate;
        this.imgUrl = imgUrl;
        this.isAlone = isAlone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getAlone() {
        return isAlone;
    }

    public void setAlone(Boolean alone) {
        isAlone = alone;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
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

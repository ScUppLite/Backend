
package com.scupp.scupplite.dto.user;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.scupp.scupplite.dto.category.CategoryDTO;
import com.scupp.scupplite.entities.Category;
import com.scupp.scupplite.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class UserDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;
    private String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    @Column(columnDefinition = "TEXT")
    private String imgUrl;
    private Boolean isAlone;
    private List<CategoryDTO> categories = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(User entity) {
        id = entity.getId();
        isAlone = entity.getAlone();
        username = entity.getUsername();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        cpf = entity.getCpf();
        phone = entity.getPhone();
        birthDate = entity.getBirthDate();
        email = entity.getEmail();
        imgUrl = entity.getImgUrl();
    }

    public UserDTO(User entity, Set<Category> categoryEntity){
        this(entity);
        categoryEntity.forEach(x-> categories.add(new CategoryDTO(x)));
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }

}

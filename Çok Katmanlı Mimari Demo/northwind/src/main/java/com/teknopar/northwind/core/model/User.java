package com.teknopar.northwind.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
* Core katmanına eklememizin sebebi ileride de başka işlerimizde bu sınıfı kullanabileceğimizden dolayıdır
* */
@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    @Email
    @NotBlank //email alanının boş olmaması için kullandık
    @NotNull
    private String email;


    @NotBlank
    @NotNull
    @Column(name = "password")
    private String password;
}

package com.teknopar.northwind.core.repository;

import com.teknopar.northwind.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByEmail(String email);  //jpa repository tanısın diye findBy ya da getBy kullanılmalı demiştim
}

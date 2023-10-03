package com.nagarro.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.library.entities.User;

public interface UserDao extends JpaRepository<User,String>{

}

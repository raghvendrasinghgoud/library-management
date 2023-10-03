package com.nagarro.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.library.entities.Book;

public interface BookDao extends JpaRepository<Book,Integer> {

}

package com.nagarro.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.library.entities.Author;

public interface AuthorDao extends JpaRepository<Author,Integer	>{

	
}

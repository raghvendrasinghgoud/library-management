package com.nagarro.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.library.dao.AuthorDao;
import com.nagarro.library.entities.Author;

@Service
public class AuthorService {
	@Autowired
	private AuthorDao ad;
	
	public Author addAuthor(Author author) {
		ad.save(author);
		return author;
	}
	
	public Optional<Author> getAuthorById(int id) {
		return ad.findById(id);
	}
	
	public List<Author> getAuthors() {
		return ad.findAll();
	}
	
	public void deleteAuthorById(int id) {
		ad.deleteById(id);
	}
	
	
}

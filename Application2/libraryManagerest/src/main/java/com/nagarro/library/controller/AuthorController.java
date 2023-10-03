package com.nagarro.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.library.entities.Author;
import com.nagarro.library.services.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService serv;
	
	@GetMapping("/author/{id}")
	public Optional<Author> getAuthorById(@PathVariable("id") int id){
		return serv.getAuthorById(id);
	}
	
	@GetMapping("/authors")
	public List<Author> getAllAuthors(){
		return serv.getAuthors();
	}
	
	@PostMapping("/author")
	public Author saveAuthor(@RequestBody Author author) {
		return serv.addAuthor(author);		
	}
	@PutMapping("/author")
	public Author updateAuthor(@RequestBody Author author) {
		return serv.addAuthor(author);		
	}
	
	@DeleteMapping("/author/{id}")
	public String deleteAuthor(@PathVariable int id) {
		serv.deleteAuthorById(id);
		
		return "deleted";
	}
}

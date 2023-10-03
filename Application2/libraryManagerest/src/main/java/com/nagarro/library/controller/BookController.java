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

import com.nagarro.library.entities.Book;
import com.nagarro.library.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService serv;
	
	@GetMapping("bookexist/{id}")
	public String bookExists(@PathVariable("id") int id) {
		if(serv.getBookById(id).isEmpty()) {
			return "false";
		}
		return "true";
		
	}
	
	@GetMapping("/book/{id}")
	public Optional<Book> getBookById(@PathVariable("id") int id){
		return serv.getBookById(id);
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return serv.getBooks();
	}
	
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book Book) {
		return serv.addBook(Book);		
	}
	@PutMapping("/book")
	public Book updateBook(@RequestBody Book Book) {
		return serv.addBook(Book);		
	}
	
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable int id) {
		serv.deleteBookById(id);
		
		return "deleted";
	}
}

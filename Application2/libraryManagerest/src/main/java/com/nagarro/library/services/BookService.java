package com.nagarro.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.library.dao.BookDao;
import com.nagarro.library.entities.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDao bd;
	
	public Book addBook(Book Book) {
		bd.save(Book);
		return Book;
	}
	
	public Optional<Book> getBookById(int id) {
		return bd.findById(id);
	}
	
	public List<Book> getBooks() {
		return bd.findAll();
	}
	
	public void deleteBookById(int id) {
		bd.deleteById(id);
	}
	
}

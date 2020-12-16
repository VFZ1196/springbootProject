package com.javatpoint.controller;

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

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;
import com.javatpoint.service.BooksService;

@RestController
public class BooksController {
	/*

	@Autowired
	BooksService service;
	
	//retrieve all the books from database
	@GetMapping("/book")
	private List<Books> getAllBooks(){
		return service.getAllBooks();
	}
	//retrieve a specific book from database
	@GetMapping("/book/{bookid}")
	private Books getBooks(@PathVariable("bookid") long bookid) {
		return service.getBooksById(bookid);
	}
	
	//delete a specific book
	@DeleteMapping("/book/{bookid}")
	private void deleteBook(@PathVariable("bookid") long bookid) {
		service.delete(bookid);
	}
	
	
	//post the book detail in the database
	@PostMapping("/books")
	private Books saveBook(@RequestBody Books books) {
		return service.saveOrUpdate(books);
		//return books.getBookid();
		//return books;
	}
	
	//put mapping that updates the book detail
	@PutMapping("/books")
	private Books update(@RequestBody Books books) {
		service.saveOrUpdate(books);
		return books;
	}
	*/
	
	@Autowired
	BooksRepository booksRepository;
	
	@GetMapping("/books")
	private List<Books> getAllBooks(){
		return booksRepository.findByOrderByBookIdDesc();
	}
	
	@GetMapping("/books/{bookid}")
	private Books getBooks(@PathVariable("bookid") Long bookid) {
		return booksRepository.findById(bookid).get();
	}
	
	@DeleteMapping("/books/{bookid}")
	private void deleteBook(@PathVariable("bookid") Long bookid) {
		booksRepository.deleteById(bookid);
	}
	
	@PostMapping("/books")
	private Books saveBook(@RequestBody Books books) {
		return booksRepository.save(books);
	}
	/*
	@PutMapping("/books/{bookid}")
	private Books update(@PathVariable("bookid") Long bookid) {
		Optional<Books> books = booksRepository.findById(bookid);		
		Books updateBook = booksRepository.save(books);
		return updateBook;
                                                     
    }
    */

}

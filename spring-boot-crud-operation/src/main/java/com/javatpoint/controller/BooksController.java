package com.javatpoint.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;

@RestController
@CrossOrigin
public class BooksController {

	private final Logger log = LoggerFactory.getLogger(BooksController.class);

	/*
	 * @Autowired BooksService service;
	 * 
	 * //retrieve all the books from database
	 * 
	 * @GetMapping("/book") private List<Books> getAllBooks(){ return
	 * service.getAllBooks(); } //retrieve a specific book from database
	 * 
	 * @GetMapping("/book/{bookId}") private Books getBooks(@PathVariable("bookId")
	 * long bookId) { return service.getBooksById(bookId); }
	 * 
	 * //delete a specific book
	 * 
	 * @DeleteMapping("/book/{bookId}") private void
	 * deleteBook(@PathVariable("bookId") long bookId) { service.delete(bookId); }
	 * 
	 * 
	 * //post the book detail in the database
	 * 
	 * @PostMapping("/books") private Books saveBook(@RequestBody Books books) {
	 * return service.saveOrUpdate(books); //return books.getBookid(); //return
	 * books; }
	 * 
	 * //put mapping that updates the book detail
	 * 
	 * @PutMapping("/books") private Books update(@RequestBody Books books) {
	 * service.saveOrUpdate(books); return books; }
	 */

	@Autowired
	BooksRepository booksRepository;

	@GetMapping("/books")
	private List<Books> getAllBooks() {
		log.info("Successfully record fetched");
		return booksRepository.findByOrderByBookId();
	}

	@GetMapping("/books/{bookId}")
	private Optional<Books> getBooks(@PathVariable Long bookId) {

		Optional<Books> book = booksRepository.findById(bookId);
		if (book.isPresent()) {
			log.info("Successsfully record fetched of bookId " + bookId);
		}
		return book;
	}

	@DeleteMapping("/books/{bookId}")
	private void deleteBook(@PathVariable Long bookId) {
		System.out.println("bookid"+bookId);
	Optional<Books> book = booksRepository.findById(bookId);
		if (book.isPresent()) {
			log.info("Successfully record deleted of bookId " + bookId);
		}
		booksRepository.deleteById(bookId);
	}

	@PostMapping("/books")
	private Books saveBook(@RequestBody Books books) {
		log.info("Successfully record inserted");
		return booksRepository.save(books);
	}
	/*
	 * @PutMapping("/books/{bookId}") private Books update(@PathVariable("bookId")
	 * Long bookId) { Optional<Books> books = booksRepository.findById(bookId);
	 * Books updateBook = booksRepository.save(books); return updateBook;
	 * 
	 * }
	 */

}

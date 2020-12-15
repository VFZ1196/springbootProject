package com.javatpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;

//Define the business logic
@Service
public class BooksService {
	
	@Autowired
	BooksRepository booksRepository;

	//getting all books record by using the method findAll() of CrudRepository
	public List<Books> getAllBooks() {
		//List<Books> books = new ArrayList<Books>();
		  return booksRepository.findAll();
		   //.forEach(books1 ->books.add(books1));
		  // return books;
	}
	//getting a specific record by findById() method
/*
	public Books getBooksById(long id) {
	    return booksRepository.findById(id).get();
	}
	*/
	//saving a specific record by save() method
	public Books saveOrUpdate(Books books) {
		return booksRepository.save(books);
	}
	/*
	
	//deleting a specific record  by deleteById() method
	public void delete(long id) {
		booksRepository.deleteById(id);
	}	
	
	//update a record
	public void update(Books books, long bookid) {
		booksRepository.save(books);
	}
	*/
	

}

package com.javatpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
	
	@Query(value="select * from books order by book_id Desc", nativeQuery=true)
	
	//@Query(value="select * from books order by price DESC", nativeQuery=true)
	
	//@Query(value = "select * from books", nativeQuery = true)
	
	//@Query(value="select * from books where book_id>49", nativeQuery = true)
	
	//@Query(value="select * from books where price>450", nativeQuery = true)
	
	//This query is not working why?
	//@Query(value="select books.book_name from books where book_id=48", nativeQuery=true)
		
    List<Books> findByOrderByBookId();

}
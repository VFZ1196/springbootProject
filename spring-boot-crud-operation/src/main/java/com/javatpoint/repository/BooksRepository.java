package com.javatpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.Books;


@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
	
    List<Books> findAllByOrderByBookidDesc();
    
    
  //  List<Books> books = BooksRepository.findAll(Sort.by(Sort.Direction.ASC, "bookid"));

}

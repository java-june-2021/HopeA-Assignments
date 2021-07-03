package com.HopeA.mvc.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.HopeA.mvc.services.Book;

import antlr.collections.List;


public class BookRepository {
	@Repository
	public interface BookRepository extends CrudRepository<Book, Long>{
	    // this method retrieves all the books from the database
	    List<Book> findAll();
	    // this method find a book by their description
	    List<Book> findByDescriptionContaining(String search);
	    // this method counts how many titles contain a certain string
	    Long countByTitleContaining(String search);
	    // this method deletes a book that starts with a specific title
	    Long deleteByTitleStartingWith(String search);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Book save(com.HopeA.mvc.controllers.Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Book> findById(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}

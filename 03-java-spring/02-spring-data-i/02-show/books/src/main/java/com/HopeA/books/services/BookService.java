package com.HopeA.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HopeA.books.models.Book;
import com.HopeA.books.repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bRepo;
	public BookService(BookRepository bRepo) {
		this.bRepo = bRepo;
	}
	
	//Display All
	public List<Book> allBooks() {
		return this.bRepo.findAll();
	}
	
	//Create
	public Book createBook(Book book) {
		return this.bRepo.save(book);
	}
	//Read
	public Book getOneBook(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
	//Update
	public Book updateBook(Book book) {
		return this.bRepo.save(book);
	}
	//Delete
	public String deleteBook(Long id) {
		return "Book " + id + " has been deleted.";
	}

	public Book findBook(int index) {
		return null;
	}

	public Book findBook(String string) {
		return null;
	}
}

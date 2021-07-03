package com.HopeA.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HopeA.books.models.Book;
import com.HopeA.books.repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bRepo;
	private Book book;
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
	public Book updateBook(Long id, Book book) {
		if (bRepo.existsById(id))  {
			bRepo.save(book);
		}
		return this.bRepo.save(book);
	}
	//Delete
	public void destroyBook(Long id) {
		//book = null;
		if (bRepo.existsById(id)) {
			bRepo.deleteById(id);
		}
	}

	public Book findBook(int index) {
		return null;
	}

	public Book findBook(String string) {
		return null;
	}

	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		
	}
}

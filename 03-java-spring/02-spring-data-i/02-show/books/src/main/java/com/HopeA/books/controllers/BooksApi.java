package com.HopeA.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HopeA.books.models.Book;
import com.HopeA.books.services.BookService;

@RestController
public class BooksApi {
	private BookService bService;
	public BooksApi(BookService bService) {
		this.bService = bService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bService.allBooks();
	}
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String 		language, @RequestParam(value="pages") Integer numberOfPages) {
        Book book = new Book(title, description, language, numberOfPages);
        return bService.createBook(book);
	}
	
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id")Long id) {
		Book book = bService.findBook("id");
		return book;
	}
	
//	@RequestMapping(value="/books/delete/{id}")
//    public String destroyBook(@PathVariable("id") int id) {
//        bService.destroyBook(id);
//        return "redirect:/books";
//    }
	

}

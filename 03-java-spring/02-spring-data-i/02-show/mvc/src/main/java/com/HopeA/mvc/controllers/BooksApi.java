package com.HopeA.mvc.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HopeA.mvc.services.BookService;

import antlr.collections.List;

@RestController
public class BooksApi {
	// defining our BookService field
    private BookService bookService;
    // we can initialize our BookService object in the BooksApi constructor, using Dependency Injection
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/api/books")
    public List index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public com.HopeA.mvc.services.Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book();
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public com.HopeA.mvc.services.Book show(@PathVariable("id") Long id) {
        com.HopeA.mvc.services.Book book = bookService.findBook(id);
        return book;
    }
}

package com.HopeA.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HopeA.books.models.Book;
import com.HopeA.books.services.BookService;

@Controller
public class HomeController {
	@Autowired
	private BookService bService;
	
	public HomeController(BookService bService) {
		this.bService = bService;
	}
	
	@RequestMapping("/books")
	public String index(Model viewModel) {
		List<Book> books = bService.allBooks();
		viewModel.addAttribute("books", books);
		return "/books/index.jsp";
	}
//	
//	@RequestMapping("/books/{index}")
//	public String findBookByIndex(Model viewModel, @PathVariable("index") int index) {
//        Book book = bService.findBook(index);
//        viewModel.addAttribute("book", book);
//        return "showBook.jsp";
//	}
//	
//	@RequestMapping("/books/new")
//	public String newBook(@ModelAttribute("book") Book book) {
//		return "new.jsp";
//	}
//	
	@RequestMapping(value="/books/new")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "/books/new.jsp";
		}else {
			bService.createBook(book);
			return "redirect:/books";
		}
	}
	
//	@GetMapping("/")
//	public List<Book> allBooks() {
//		return this.bService.allBooks();
//		
//	}
	
	@GetMapping("/{id}")
	public Book getOneBook(@PathVariable("id") Long id) {
		return this.bService.getOneBook(id);
	}

	@PostMapping("/create")
	public Book createBook(Book book) {
		return this.bService.createBook(book);
	}
	
	@DeleteMapping("/delete/{id}") 
	public void deleteBook(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
	}
	
}

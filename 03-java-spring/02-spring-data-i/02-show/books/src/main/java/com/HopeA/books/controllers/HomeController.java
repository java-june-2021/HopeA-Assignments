package com.HopeA.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "books/new.jsp";
	}
	
	@RequestMapping(value="/books/new", method=RequestMethod.POST)
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
	
	@RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model viewModel) {
        Book book = bService.findBook(id);
        if (book != null){
            viewModel.addAttribute("book", book);
            return "editBook.jsp";
        }else{
            return "redirect:/books";
        }
    }
	
	  @PostMapping("/books/edit/{id}")
	    public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "editBook.jsp";
	        }else{
	            bService.updateBook(id, book);
	            return "redirect:/books";
	        }
	    }

	@PostMapping("/create")
	public Book createBook(Book book) {
		return this.bService.createBook(book);
	}
	
//	@DeleteMapping("/delete/{id}") 
//	public void deleteBook(@PathVariable("id") Long id) {
//		this.bService.deleteBook(id);
//	}
	
//	@RequestMapping(value="/books/delete/{id}")
//    public String destroyBook(@PathVariable("id") int id) {
//        bService.destroyBook(id);
//        return "redirect:/books";
//    }
	
	@RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") Long id) {
		//bService = null;
		bService.destroyBook(id);
        return "redirect:/books";
    }
	
}

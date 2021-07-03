package com.HopeA.mvc.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import antlr.collections.List;

@Service
public class BookService {
    private static final ArrayList<Book> ARRAY_LIST3 = new ArrayList<Book>(Arrays.asList(
            new Book(),
            new Book(),
            new Book(),
            new Book(),
            new Book()
            ));
	private static final ArrayList<Book> ARRAY_LIST2 = ARRAY_LIST3;
	private static final ArrayList<Book> ARRAY_LIST = ARRAY_LIST2;
	private List books = (List) ARRAY_LIST;
    
    public List allBooks() {
        return books;
    }
    
    public Book findBookByIndex(int index) {
        if (index < ((ArrayList<?>) books).size()){
            return (Book) ((ArrayList<?>) books).get(index);
        }else{
            return null;
        }
    }

	public void createBook(com.HopeA.mvc.controllers.Book book) {
		
	}
}

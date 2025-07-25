package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private String libraryName;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Constructor: BookRepository injected.");
    }

    // Setter Injection
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        System.out.println("Setter: Library name set to " + libraryName);
    }

    public void display() {
        System.out.println("BookService: Displaying books from " + libraryName);
        bookRepository.save();
    }
}

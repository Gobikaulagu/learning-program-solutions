package com.library.service;

public class BookService {
    public void addBook(String bookName) {
        System.out.println("📖 Book added: " + bookName);
    }

    public void deleteBook(String bookName) {
        System.out.println("❌ Book deleted: " + bookName);
    }
}

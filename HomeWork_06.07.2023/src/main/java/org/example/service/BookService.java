package org.example.service;

import org.example.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book find(long ISBN);

    Book borrowFromLibrary(long ISBN);

    boolean returnToLibrary(Book book);
}

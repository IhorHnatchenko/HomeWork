package org.example.repository;

import org.example.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();

    Book find(long ISBN);

    Book borrowFromLibrary(long ISBN);

    boolean returnToLibrary(Book book);
}

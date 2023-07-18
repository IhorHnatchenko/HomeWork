package org.example.repository;

import org.example.model.Author;
import org.example.model.Book;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private Map<Long, Book> bookStorage = new HashMap<>();

    @PostConstruct
    private void init() {
        bookStorage.put(12345L, new Book("Harry Potter I", 12345L, new Author("J", "Rowling"), 1995));
        bookStorage.put(12346L, new Book("Harry Potter II", 12346L, new Author("J", "Rowling"), 1996));
        bookStorage.put(12347L, new Book("Harry Potter III", 12347L, new Author("J", "Rowling"), 1997));
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>(bookStorage.values());
        return books;
    }

    @Override
    public Book find(long ISBN) {
        return bookStorage.get(ISBN);
    }

    @Override
    public Book borrowFromLibrary(long ISBN) {
        return bookStorage.remove(ISBN);
    }

    @Override
    public boolean returnToLibrary(Book book) {
        bookStorage.put(book.getISBN(), book);
        return true;
    }
}

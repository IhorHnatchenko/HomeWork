package org.example.service;

import org.example.model.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Book find(long ISBN) {
        return bookRepository.find(ISBN);
    }

    @Override
    public Book borrowFromLibrary(long ISBN) {
        return bookRepository.borrowFromLibrary(ISBN);
    }

    @Override
    public boolean returnToLibrary(Book book) {
        return bookRepository.returnToLibrary(book);
    }
}

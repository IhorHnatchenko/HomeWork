package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> list() {
        return bookService.getAll();
    }

    @GetMapping("/{ISBN}")
    public Book getOne(@PathVariable(name = "ISBN") long ISBN) {
        return bookService.find(ISBN);
    }

    @PostMapping("/return")
    public void returnBoolToLibrary(@RequestBody Book book) {
        bookService.returnToLibrary(book);
    }

    @PostMapping("/borrow/{ISBN}")
    public Book borrowBookFromLibrary(@PathVariable(name = "ISBN") long ISBN) {
        return bookService.borrowFromLibrary(ISBN);
    }
}

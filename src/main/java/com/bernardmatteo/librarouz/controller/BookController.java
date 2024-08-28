package com.bernardmatteo.librarouz.controller;

import com.bernardmatteo.librarouz.model.Book;
import com.bernardmatteo.librarouz.response.Response;
import com.bernardmatteo.librarouz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return this.bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return this.bookService.getBookById(Long.parseLong(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteBook(@PathVariable String id) {
        this.bookService.deleteBook(Long.parseLong(id));
        Response response = new Response("Book deleted successfully", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateBook(@PathVariable String id, @RequestBody Book book) {
        boolean updated = this.bookService.updateBook(Long.parseLong(id), book);
        if (!updated) {
            Response response = new Response("Book not found", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Book updated successfully", true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

}

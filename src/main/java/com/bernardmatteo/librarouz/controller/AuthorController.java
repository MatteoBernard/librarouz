package com.bernardmatteo.librarouz.controller;

import com.bernardmatteo.librarouz.model.Author;
import com.bernardmatteo.librarouz.response.Response;
import com.bernardmatteo.librarouz.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAutors() {
        return this.authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable String id) {
        return this.authorService.getAuthorById(Long.parseLong(id));
    }

    @GetMapping("/name/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return this.authorService.getAuthorByName(name);
    }

    @PostMapping
    public ResponseEntity<Response> saveAuthor(@RequestBody Author author) {
        this.authorService.saveAuthor(author);
        Response response = new Response("Author saved successfully", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteAuthor(@PathVariable String id) {
        this.authorService.deleteAuthor(Long.parseLong(id));
        Response response = new Response("Author deleted successfully", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateAuthor(@PathVariable String id, @RequestBody Author author) {
        boolean updated = this.authorService.updateAuthor(Long.parseLong(id), author);
        if (!updated) {
            Response response = new Response("Author not found", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Author updated successfully", true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

}
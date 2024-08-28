package com.bernardmatteo.librarouz.service;

import com.bernardmatteo.librarouz.model.Author;
import com.bernardmatteo.librarouz.model.Book;
import com.bernardmatteo.librarouz.repository.AuthorRepository;
import com.bernardmatteo.librarouz.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book addBookToAuthor(Long authorId, Book book) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public boolean updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setGenre(book.getGenre());
            existingBook.setPublicationYear(book.getPublicationYear());

            bookRepository.save(existingBook);
            return true;
        }
        return false;
    }
}

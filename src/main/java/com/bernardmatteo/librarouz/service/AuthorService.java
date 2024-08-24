package com.bernardmatteo.librarouz.service;

import com.bernardmatteo.librarouz.model.Author;
import com.bernardmatteo.librarouz.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository autorRepository) {
        this.authorRepository = autorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findByFirstName(name).orElse(null);
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public boolean updateAuthor(Long id, Author author) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setFirstName(author.getFirstName());
            existingAuthor.setLastName(author.getLastName());
            existingAuthor.setBirthDate(author.getBirthDate());
            authorRepository.save(existingAuthor);
            return true;
        }
        return false;
    }
}

package com.bernardmatteo.librarouz.repository;

import com.bernardmatteo.librarouz.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByFirstName(String firstName);

}
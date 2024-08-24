package com.bernardmatteo.librarouz.repository;

import com.bernardmatteo.librarouz.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

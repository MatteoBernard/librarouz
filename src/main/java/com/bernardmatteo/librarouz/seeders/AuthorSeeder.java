package com.bernardmatteo.librarouz.seeders;

import com.bernardmatteo.librarouz.model.Author;
import com.bernardmatteo.librarouz.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AuthorSeeder {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorSeeder(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void initializeAuthors() {
        if (authorRepository.count() == 0) {
            authorRepository.save(new Author("Lena", "Oxton", LocalDate.of(1986, 2, 12)));
            authorRepository.save(new Author("Winston", "Overwatch", LocalDate.of(2000, 12, 12)));
            authorRepository.save(new Author("Gabriel", "Reyes", LocalDate.of(1958, 12, 3)));
            authorRepository.save(new Author("Angela", "Ziegler", LocalDate.of(1979, 5, 1)));
            authorRepository.save(new Author("Genji", "Shimada", LocalDate.of(1985, 10, 28)));
            authorRepository.save(new Author("Hanzo", "Shimada", LocalDate.of(1980, 11, 3)));
            authorRepository.save(new Author("Hana", "Song", LocalDate.of(2001, 6, 22)));
            authorRepository.save(new Author("Jack", "Morrison", LocalDate.of(1950, 1, 27)));
            authorRepository.save(new Author("Mei-Ling", "Zhou", LocalDate.of(1982, 9, 5)));
            authorRepository.save(new Author("Aleksandra", "Zaryanova", LocalDate.of(1991, 12, 4)));
            authorRepository.save(new Author("Ana", "Amari", LocalDate.of(1960, 9, 21)));
            authorRepository.save(new Author("Amélie", "Lacroix", LocalDate.of(1984, 11, 19)));
            authorRepository.save(new Author("Satya", "Vaswani", LocalDate.of(1995, 5, 30)));
            authorRepository.save(new Author("Lúcio", "Correia dos Santos", LocalDate.of(1990, 3, 20)));
            authorRepository.save(new Author("Bastion", "Overwatch", LocalDate.of(2016, 4, 12)));
            authorRepository.save(new Author("Minerva", "Liao", LocalDate.of(1983, 8, 9)));
            authorRepository.save(new Author("Cole", "Cassidy", LocalDate.of(2040, 12, 12)));
            authorRepository.save(new Author("Olivia", "Almeida", LocalDate.of(2029, 7, 14)));
            authorRepository.save(new Author("Moira", "O'Deorain", LocalDate.of(1971, 4, 4)));
        }

    }
}

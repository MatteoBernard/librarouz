package com.bernardmatteo.librarouz.seeders;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final AuthorSeeder authorSeeder;
    private final BookSeeder bookSeeder;

    @Autowired
    public DataInitializer(AuthorSeeder authorSeeder, BookSeeder bookSeeder) {
        this.authorSeeder = authorSeeder;
        this.bookSeeder = bookSeeder;
    }

    @PostConstruct
    public void initializeData() {
        authorSeeder.initializeAuthors();
        bookSeeder.initializeBooks();
    }
}

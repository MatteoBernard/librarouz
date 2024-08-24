package com.bernardmatteo.librarouz.seeders;

import com.bernardmatteo.librarouz.model.Author;
import com.bernardmatteo.librarouz.model.Book;
import com.bernardmatteo.librarouz.repository.AuthorRepository;
import com.bernardmatteo.librarouz.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookSeeder {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookSeeder(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void initializeBooks() {
        if (bookRepository.count() == 0) {
            // Get authors
            Optional<Author> lena = authorRepository.findByFirstName("Lena");
            Optional<Author> winston = authorRepository.findByFirstName("Winston");
            Optional<Author> gabriel = authorRepository.findByFirstName("Gabriel");
            Optional<Author> angela = authorRepository.findByFirstName("Angela");
            Optional<Author> genji = authorRepository.findByFirstName("Genji");
            Optional<Author> hanzo = authorRepository.findByFirstName("Hanzo");
            Optional<Author> hana = authorRepository.findByFirstName("Hana");
            Optional<Author> jack = authorRepository.findByFirstName("Jack");
            Optional<Author> mei = authorRepository.findByFirstName("Mei");
            Optional<Author> aleksandra = authorRepository.findByFirstName("Aleksandra");
            Optional<Author> ana = authorRepository.findByFirstName("Ana");
            Optional<Author> jeff = authorRepository.findByFirstName("Amélie");
            Optional<Author> satya = authorRepository.findByFirstName("Satya");
            Optional<Author> lucio = authorRepository.findByFirstName("Lúcio");
            Optional<Author> bastion = authorRepository.findByFirstName("Bastion");
            Optional<Author> minerva = authorRepository.findByFirstName("Minerva");
            Optional<Author> cole = authorRepository.findByFirstName("Cole");
            Optional<Author> olivia = authorRepository.findByFirstName("Olivia");
            Optional<Author> moira = authorRepository.findByFirstName("Moira");


            // Initialize books
            lena.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Journey Begins", autor, "978-1-4215-0601-4", "Adventure", 2017));
            });

            winston.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Last Stand", autor, "978-1-4215-0602-1", "Action", 2020));
            });

            gabriel.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: Dark Horizons", autor, "978-1-4215-0603-8", "Thriller", 2021));
                bookRepository.save(new Book("Dragon Ball: Shadows of War", autor, "978-1-4215-0604-5", "Action", 2022));
            });

            angela.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: Healing Light", autor, "978-1-4215-0605-2", "Fantasy", 2019));
            });

            genji.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: Warriors of the Dawn", autor, "978-1-4215-0606-9", "Adventure", 2021));
            });

            hanzo.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Clan Legacy", autor, "978-1-4215-0607-6", "Fantasy", 2020));
            });

            hana.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Virtual Battle", autor, "978-1-4215-0608-3", "Science Fiction", 2021));
                bookRepository.save(new Book("Dragon Ball: The Gamer's Quest", autor, "978-1-4215-0609-0", "Adventure", 2022));
            });

            jack.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: Legacy of Heroes", autor, "978-1-4215-0610-7", "Action", 2019));
            });

            mei.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: Frozen Warriors", autor, "978-1-4215-0611-4", "Fantasy", 2020));
            });

            aleksandra.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: Strength Unleashed", autor, "978-1-4215-0612-1", "Action", 2021));
            });

            ana.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Hidden Power", autor, "978-1-4215-0613-8", "Adventure", 2020));
            });

            jeff.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Secret of the Ancients", autor, "978-1-4215-0614-5", "Mystery", 2022));
            });

            satya.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Cosmic Odyssey", autor, "978-1-4215-0615-2", "Science Fiction", 2021));
            });

            lucio.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Rhythm of War", autor, "978-1-4215-0616-9", "Adventure", 2019));
            });

            bastion.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: Echoes of the Past", autor, "978-1-4215-0617-6", "Historical Fiction", 2021));
            });

            minerva.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Age of Legends", autor, "978-1-4215-0618-3", "Fantasy", 2020));
            });

            cole.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Lost Prophecy", autor, "978-1-4215-0619-0", "Adventure", 2019));
            });

            olivia.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Shadow's Embrace", autor, "978-1-4215-0620-6", "Thriller", 2021));
            });

            moira.ifPresent(autor -> {
                bookRepository.save(new Book("Dragon Ball: The Dark Alchemy", autor, "978-1-4215-0621-3", "Fantasy", 2022));
            });
        }

    }
}

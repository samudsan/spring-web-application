package com.san.springwebapplication.bootstrap;

import com.san.springwebapplication.domain.Author;
import com.san.springwebapplication.domain.Book;
import com.san.springwebapplication.domain.Publisher;
import com.san.springwebapplication.repository.AuthorRepository;
import com.san.springwebapplication.repository.BookRepository;
import com.san.springwebapplication.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create first author, book and publisher
        Author author1 = new Author("Goggins", "John");
        Book book1 = new Book("Never Finished", "123");
        Publisher publisher1 = new Publisher("Goa", 231564L);
        publisherRepository.save(publisher1);
        book1.setPublisher(publisher1);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        publisher1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);


        // Create second author, book and publisher
        Author author2 = new Author("Smith", "Sarah");
        Book book2 = new Book("You Can't Hurt Me", "456");
        Publisher publisher2 = new Publisher("London", 231556L);
        publisherRepository.save(publisher2);
        book2.setPublisher(publisher2);
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        publisher2.getBooks().add(book2);

        authorRepository.save(author2);

        bookRepository.save(book2);


        System.out.println("Started in BootStrap Class");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of books assigned to a publisher: " + publisherRepository.count());
    }
}

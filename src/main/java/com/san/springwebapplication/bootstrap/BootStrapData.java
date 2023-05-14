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
        Author author  = new Author("Goggins","john");
        Book book =  new Book("Never Finished","123");
        Publisher publisher1 = new Publisher("Goa", 231564L);
        book.setPublisher(publisher1);
        author.getBooks().add(book);
        book.getAuthors().add(author);
        publisher1.getBooks().add(book);


        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher1);

        Author author2  = new Author("Goggins","john");
        Book book2 =  new Book("you can't hurt me","123");
        Publisher publisher2 = new Publisher("Goa", 231556);
        book2.setPublisher(publisher2);
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        publisher2.getBooks().add(book2);
        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher2);


        System.out.println("Started in BootStrap Class");
        System.out.println("Number of books : "+bookRepository.count());
        System.out.println("Number of  books assigned to publisher: "+publisherRepository.count());

    }
}

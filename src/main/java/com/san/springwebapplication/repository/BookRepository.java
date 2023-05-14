package com.san.springwebapplication.repository;

import com.san.springwebapplication.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

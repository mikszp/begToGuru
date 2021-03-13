package com.mszpila.quickproject.repos;

import com.mszpila.quickproject.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}

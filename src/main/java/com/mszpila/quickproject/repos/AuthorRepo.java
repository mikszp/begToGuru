package com.mszpila.quickproject.repos;

import com.mszpila.quickproject.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}

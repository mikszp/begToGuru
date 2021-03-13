package com.mszpila.quickproject.repos;

import com.mszpila.quickproject.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}

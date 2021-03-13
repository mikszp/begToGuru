package com.mszpila.quickproject.bootstraps;

import com.mszpila.quickproject.domain.Author;
import com.mszpila.quickproject.domain.Book;
import com.mszpila.quickproject.domain.Publisher;
import com.mszpila.quickproject.repos.AuthorRepo;
import com.mszpila.quickproject.repos.BookRepo;
import com.mszpila.quickproject.repos.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ericEvans = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        ericEvans.getBooks().add(ddd);
        ddd.getAuthors().add(ericEvans);

        authorRepo.save(ericEvans);
        bookRepo.save(ddd);

        Author rodJohnson = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "987987");
        rodJohnson.getBooks().add(noEJB);
        noEJB.getAuthors().add(rodJohnson);

        authorRepo.save(rodJohnson);
        bookRepo.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("No. of Books: " + bookRepo.count());

        Publisher pwn = new Publisher("pwn","XYZ", "Gliwice", "śląsk", "44-100");
        publisherRepo.save(pwn);

        ddd.setPublisher(pwn);
        pwn.getBooks().add(ddd);

        publisherRepo.save(pwn);

        System.out.println("No. of Publishers: " + publisherRepo.count());
    }
}

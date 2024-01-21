package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){this.authorRepository = authorRepository;}

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public void destroy(Long id) {
        authorRepository.deleteById(id);
    }

    public Optional<Author> getOne(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}

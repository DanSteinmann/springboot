package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }
}

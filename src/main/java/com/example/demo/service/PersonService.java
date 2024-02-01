package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Person;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> getOne(Long id) {
        return personRepository.findById(id);
    }

    public Person addAddress(Long personId, Address address) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));

        address.setPerson(person);
        addressRepository.save(address);
        return personRepository.save(person);
    }

    public Person addAdresses(Long personId, List<Address> addresses){
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
        for (Address address : addresses) {
            address.setPerson(person);
            addressRepository.save(address);
        }
        return personRepository.save(person);
    }
}

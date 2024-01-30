package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
@AllArgsConstructor
public class PersonController {

    private  final PersonService personService;

    @PostMapping(value = "", consumes =  "application/json", produces = "application/json")
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping(value = "{id}/address", consumes =  "application/json", produces = "application/json")
    public Person addAddress(@PathVariable Long id, @RequestBody Address address){
        return personService.addAddress(id, address);
    }

}

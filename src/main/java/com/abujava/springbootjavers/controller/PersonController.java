package com.abujava.springbootjavers.controller;

import com.abujava.springbootjavers.entity.Person;
import com.abujava.springbootjavers.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 12/6/2022
 */
@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping
    public Person create(@RequestBody Person newPerson) {
        return personRepository.save(newPerson);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person newPerson) {
        Person person = personRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        person.setEmail(newPerson.getEmail());

        return personRepository.save(newPerson);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        personRepository.delete(person);
        return "Person deleted!";
    }

}

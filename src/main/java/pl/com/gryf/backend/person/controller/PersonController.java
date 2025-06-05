package pl.com.gryf.backend.person.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.gryf.backend.person.dto.PersonDto;
import pl.com.gryf.backend.person.entity.Person;

import pl.com.gryf.backend.person.repository.PersonRepository;
import pl.com.gryf.backend.person.service.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;

    //Create
    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/persons")
    public List<PersonDto> getPersons() {
        return personRepository.findAll()
                .stream()
                .map(PersonDto::of)
                .collect(Collectors.toList());
    }

    //Get by Id
    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id) {
        return personRepository.findById(id);
    }

}

package pl.com.gryf.backend.person.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.gryf.backend.person.entity.Person;
import pl.com.gryf.backend.person.repository.PersonRepository;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    private Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Optional<Person> findPersonByEmail(String email) {
        return personRepository.findPersonByEmail(email);
    }

}

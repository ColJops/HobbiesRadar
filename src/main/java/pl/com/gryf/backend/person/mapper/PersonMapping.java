package pl.com.gryf.backend.person.mapper;

import org.springframework.stereotype.Component;
import pl.com.gryf.backend.person.entity.Person;
import pl.com.gryf.backend.person.record.PersonDetails;
import pl.com.gryf.backend.person.record.PersonRequest;
import pl.com.gryf.backend.person.service.PersonService;

public class PersonMapping {

    @Component
    class PersonMapper {

        private final PersonService personService;

        public PersonMapper(PersonService personService) {
            this.personService = personService;
        }

        public Person map(PersonRequest personRequest) {
            var person = personService.findPersonByEmail(personRequest.email());
            return new Person(
                    person.map(Person::getId).orElse(null), // Pobieramy id lub null
                    personRequest.login(),
                    personRequest.firstName(),
                    personRequest.lastName(),
                    personRequest.email()
            );
        }

        @Component
        class ModelMapping {
            public PersonDetails map(Person  person) {
                return new PersonDetails(
                        person.getId(),
                        person.getLogin(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getEmail()
                );
            }
        }

    }
}

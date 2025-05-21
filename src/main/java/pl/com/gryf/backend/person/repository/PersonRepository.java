package pl.com.gryf.backend.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.com.gryf.backend.person.entity.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("""
    SELECT p FROM Person p
        WHERE p.email= : email
    """)
    Optional<Person> findPersonByEmail(@Param("email") String email);

}

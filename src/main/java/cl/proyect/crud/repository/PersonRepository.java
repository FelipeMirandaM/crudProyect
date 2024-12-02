package cl.proyect.crud.repository;


import cl.proyect.crud.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();

    Optional<Person> findById(Long id);


}

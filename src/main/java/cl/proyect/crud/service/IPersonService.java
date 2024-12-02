package cl.proyect.crud.service;

import cl.proyect.crud.dto.PersonDTO;
import cl.proyect.crud.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPersonService {

    ResponseEntity<List<PersonDTO>> getAllPersons();

    ResponseEntity<PersonDTO> getPersonById(Long id);

    ResponseEntity<PersonDTO> createPerson(PersonDTO personDTO);

    ResponseEntity<Void> deletePerson(Long id);

    ResponseEntity<PersonDTO> updatePerson(Long id, PersonDTO personDTO);

}

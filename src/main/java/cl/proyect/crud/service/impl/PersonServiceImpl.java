package cl.proyect.crud.service.impl;

import cl.proyect.crud.dto.PersonDTO;
import cl.proyect.crud.exception.PersonNotFoundException;
import cl.proyect.crud.mapper.PersonMapper;
import cl.proyect.crud.model.Person;
import cl.proyect.crud.repository.PersonRepository;
import cl.proyect.crud.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {

    private final PersonRepository personRepository;

    private final PersonMapper mapper;

    @Override
    public ResponseEntity<List<PersonDTO>> getAllPersons() {

        List<Person> personList =  personRepository.findAll();

        return new ResponseEntity<>(mapper.toDTO(personList), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<PersonDTO> getPersonById(Long id) {

        Person person =  personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found"));

        return new ResponseEntity<>(mapper.toDTO(person), HttpStatus.OK);

    }
    @Override
    public ResponseEntity<PersonDTO> createPerson(PersonDTO personDTO){

        Person person = personRepository.save(mapper.toEntity(personDTO));

        return new ResponseEntity<>(mapper.toDTO(person), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deletePerson(Long id){


        personRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<PersonDTO> updatePerson(Long id, PersonDTO personDTO){

        Person person =  personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found"));

        mapper.updatePerson(person, personDTO);

        Person personUpdated = personRepository.save(person);

        return new ResponseEntity<>(mapper.toDTO(personUpdated), HttpStatus.OK);
    }


}

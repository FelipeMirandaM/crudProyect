package cl.proyect.crud.controller;

import cl.proyect.crud.dto.PersonDTO;
import cl.proyect.crud.model.Person;
import cl.proyect.crud.service.IPersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("Person")
@RequiredArgsConstructor
public class PersonController {


    private final IPersonService service;

    @GetMapping(path = "")
    public ResponseEntity<List<PersonDTO>> getAllPersons(){

        return service.getAllPersons();

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id){

        return service.getPersonById(id);

    }
    @PostMapping(path = "")
    public ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody PersonDTO personDTO){

        return service.createPerson(personDTO);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id){

        return service.deletePerson(id);

    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO){

        return service.updatePerson(id, personDTO);

    }


}

package cl.proyect.crud.mapper;

import cl.proyect.crud.dto.PersonDTO;
import cl.proyect.crud.dto.PetDTO;
import cl.proyect.crud.model.Person;
import cl.proyect.crud.model.Pet;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = PetMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {

    PetMapper petsMappet = Mappers.getMapper(PetMapper.class);

    PersonDTO toDTO(Person person);

    @Named("toDTONoPet")
    @Mapping( target = "pets", ignore = true )
    PersonDTO toDTONoPet(Person person);

    @IterableMapping(qualifiedByName="toDTONoPet")
    List<PersonDTO> toDTO(List<Person> persons);

    @Mapping(source = "pets", target = "pets", qualifiedByName = "petsCreation")
    Person toEntity(PersonDTO personDTO);

    @Mapping(source = "pets", target = "pets", qualifiedByName = "petsCreation")
    void updatePerson(@MappingTarget Person person, PersonDTO personDTO);

    @Named("petsCreation")
    static List<Pet> petsDTOTopets(List<PetDTO> pets) {
        return petsMappet.toEntity(pets);
    }

    @AfterMapping
    default void setPets(@MappingTarget Person person) {

        Optional.ofNullable(person.getPets())
                .ifPresent(it -> it.forEach(item -> item.setPerson(person)));

    }

}

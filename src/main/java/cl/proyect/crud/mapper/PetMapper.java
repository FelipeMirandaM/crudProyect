package cl.proyect.crud.mapper;

import cl.proyect.crud.dto.PetDTO;
import cl.proyect.crud.model.Pet;
import org.mapstruct.AfterMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetDTO toDTO(Pet pet);

    List<PetDTO> toDTO(List<Pet> pets);

    Pet toEntity(PetDTO petDTO);

    List<Pet> toEntity(List<PetDTO> petDTOs);

    @IterableMapping(qualifiedByName = "petDtoToPet")
    List<Pet> petDtoListToPetList(List<PetDTO> pets);

    @Named("petDtoToPet")
    Pet petDtoToPet(PetDTO pet);



}

package cl.proyect.crud.dto;

import cl.proyect.crud.model.Pet;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {

    private Long id;

    @Size(min = 2, message = "The name must be at least 2 characters long")
    private String name;

    @Min(value = 1, message = "The age must be greater than 1 ")
    private Integer age;

    private List<PetDTO> pets;

}

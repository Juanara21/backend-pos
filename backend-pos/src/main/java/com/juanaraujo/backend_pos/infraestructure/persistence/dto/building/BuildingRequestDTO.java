package com.juanaraujo.backend_pos.infraestructure.persistence.dto.building;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BuildingRequestDTO {

    private String nombre;
    private String direccion;
    private int pisos; 

}

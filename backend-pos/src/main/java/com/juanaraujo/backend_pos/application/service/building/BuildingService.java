package com.juanaraujo.backend_pos.application.service.building;

import com.juanaraujo.backend_pos.domain.model.building.Building;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.building.BuildingRequestDTO;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.building.BuildingResponseDTO;

import java.util.List;

public interface BuildingService {

     List<BuildingResponseDTO> getAllEdificios();

     List<BuildingResponseDTO> createBuilding(BuildingRequestDTO building);

}

package com.juanaraujo.backend_pos.application.service.building.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanaraujo.backend_pos.application.service.building.BuildingService;
import com.juanaraujo.backend_pos.domain.exception.BusinessException;
import com.juanaraujo.backend_pos.domain.model.building.Building;
import com.juanaraujo.backend_pos.domain.repository.building.BuildingRepository;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.building.BuildingRequestDTO;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.building.BuildingResponseDTO;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

   
    private final BuildingRepository buildingRepository;

    @Override
    public List<BuildingResponseDTO> getAllEdificios() {
       
        List<Building> edificios = buildingRepository.findAll();
        return edificios.stream()
                .map(edificio -> new BuildingResponseDTO(
                        edificio.getId(),
                        edificio.getNombre(),
                        edificio.getDireccion(),
                        edificio.getPisos()
                ))
                .toList();
    }

    @Override
    public List<BuildingResponseDTO> createBuilding(BuildingRequestDTO building) {

            buildingRepository.findByNombre(building.getNombre()).ifPresent(existingBuilding -> {
                    throw new BusinessException("Ya existe un edificio con el nombre: " + building.getNombre());
            });

            Building newBuilding = new Building();
            newBuilding.setNombre(building.getNombre());
            newBuilding.setDireccion(building.getDireccion());
            newBuilding.setPisos(building.getPisos());
            newBuilding.setFechaCreacion(java.time.LocalDateTime.now());

            buildingRepository.save(newBuilding);

            List<BuildingResponseDTO> edificios = getAllEdificios().stream()
                            .map(dto -> new BuildingResponseDTO(
                                            dto.getId(),
                                            dto.getNombre(),
                                            dto.getDireccion(),
                                            dto.getPisos()))
                            .toList();
            return edificios;
    }
    
}

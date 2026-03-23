package com.juanaraujo.backend_pos.application.service.building.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanaraujo.backend_pos.application.service.building.BuildingService;
import com.juanaraujo.backend_pos.domain.model.building.Building;
import com.juanaraujo.backend_pos.domain.repository.building.BuildingRepository;
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
    
}

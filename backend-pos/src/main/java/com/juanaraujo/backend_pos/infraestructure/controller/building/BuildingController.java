package com.juanaraujo.backend_pos.infraestructure.controller.building;


import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juanaraujo.backend_pos.application.service.building.BuildingService;
import com.juanaraujo.backend_pos.domain.model.building.Building;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.auth.apiResponse.ApiResponse;
import com.juanaraujo.backend_pos.infraestructure.persistence.dto.building.BuildingResponseDTO;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BuildingController {
    private final BuildingService buildingService;

    @GetMapping("/buildings")
    public ResponseEntity<ApiResponse<List<BuildingResponseDTO>>> getEdificios() {
        List<BuildingResponseDTO> edificios = buildingService.getAllEdificios();
        return ResponseEntity.ok(new ApiResponse<>(edificios, "Consulta exitosa", null));
    }
}

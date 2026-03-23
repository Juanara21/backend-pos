package com.juanaraujo.backend_pos.domain.repository.building;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juanaraujo.backend_pos.domain.model.building.Building;


public interface BuildingRepository extends JpaRepository<Building, Long> {
}
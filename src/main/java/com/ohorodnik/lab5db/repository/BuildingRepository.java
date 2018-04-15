package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BuildingRepository extends JpaRepository<Building,Integer> {
    //Page<Building> findAllBy(Pageable pageable);
}

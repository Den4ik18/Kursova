package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.ClassBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassBuildingRepository extends JpaRepository<ClassBuilding,Integer> {
}

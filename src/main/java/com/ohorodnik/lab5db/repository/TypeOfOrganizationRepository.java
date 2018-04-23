package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.TypeOfOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfOrganizationRepository extends JpaRepository<TypeOfOrganization,Integer> {
}

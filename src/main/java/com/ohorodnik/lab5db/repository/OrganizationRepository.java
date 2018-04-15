package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Integer> {
}

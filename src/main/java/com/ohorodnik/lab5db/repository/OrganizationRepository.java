package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Integer> {
}

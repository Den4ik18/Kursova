package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.ReservationOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationOrganizationRepository extends JpaRepository<ReservationOrganization,Integer>{
}

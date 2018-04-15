package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.ReservationOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationOrganizationRepository extends JpaRepository<ReservationOrganization,Integer>{
}

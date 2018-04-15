package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}

package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
}

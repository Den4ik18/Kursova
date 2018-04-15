package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}

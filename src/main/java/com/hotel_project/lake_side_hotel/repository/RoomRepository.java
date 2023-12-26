package com.hotel_project.lake_side_hotel.repository;

import com.hotel_project.lake_side_hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

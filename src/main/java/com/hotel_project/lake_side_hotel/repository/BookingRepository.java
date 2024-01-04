package com.hotel_project.lake_side_hotel.repository;

import com.hotel_project.lake_side_hotel.model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookedRoom, Long> {
}

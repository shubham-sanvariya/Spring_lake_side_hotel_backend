package com.hotel_project.lake_side_hotel.repository;

import com.hotel_project.lake_side_hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existByEmail(String email);
}

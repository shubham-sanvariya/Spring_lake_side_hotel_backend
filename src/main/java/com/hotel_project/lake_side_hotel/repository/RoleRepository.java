package com.hotel_project.lake_side_hotel.repository;

import com.hotel_project.lake_side_hotel.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String role);

    boolean existsByName(String  role);
}

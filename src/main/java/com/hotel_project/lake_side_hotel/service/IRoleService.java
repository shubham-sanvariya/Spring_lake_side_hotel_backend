package com.hotel_project.lake_side_hotel.service;

import com.hotel_project.lake_side_hotel.model.Role;
import com.hotel_project.lake_side_hotel.model.User;

import java.util.List;

public interface IRoleService {

    List<Role> getRoles();
    Role createRole(Role theRole);

    Role findByName(String name);
}

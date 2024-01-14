package com.hotel_project.lake_side_hotel.service;

import com.hotel_project.lake_side_hotel.exception.RoleAlreadyExistsException;
import com.hotel_project.lake_side_hotel.model.Role;
import com.hotel_project.lake_side_hotel.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService{
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role theRole) {
        String roleName = "ROLE_" + theRole.getName().toUpperCase();
        Role role = new Role(roleName);
        if (roleRepository.existsByName(role)){
            throw new RoleAlreadyExistsException(theRole.getName()+ " role already exists");
        }
        return roleRepository.save(role);
    }
}

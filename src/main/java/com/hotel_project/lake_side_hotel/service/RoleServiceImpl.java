package com.hotel_project.lake_side_hotel.service;

import com.hotel_project.lake_side_hotel.exception.RoleAlreadyExistsException;
import com.hotel_project.lake_side_hotel.model.Role;
import com.hotel_project.lake_side_hotel.model.User;
import com.hotel_project.lake_side_hotel.repository.RoleRepository;
import com.hotel_project.lake_side_hotel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService{
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

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

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name).get();
    }

    @Override
    public void deleteRole(Long roleId) {
        this.removeAllUsersFromRole(roleId);
        roleRepository.deleteById(roleId);
    }

    @Override
    public Role removeAllUsersFromRole(Long roleId) {
        return null;
    }

    @Override
    public User removeUserFromRole(Long userId, Long roleId) {
        Optional<User>  user = userRepository.findById(userId);
        Optional<Role>  role = roleRepository.findById(roleId);
        if (role.isPresent() && role.get().getUsers().contains(user.get())){
            role.get().removeUserFromRole(user.get());
            roleRepository.save(role.get());
            return user.get();
        }
        throw new UsernameNotFoundException("User not found");
    }

}

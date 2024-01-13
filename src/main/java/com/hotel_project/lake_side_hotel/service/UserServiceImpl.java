package com.hotel_project.lake_side_hotel.service;

import com.hotel_project.lake_side_hotel.exception.UserAlreadyExistsException;
import com.hotel_project.lake_side_hotel.model.Role;
import com.hotel_project.lake_side_hotel.model.User;
import com.hotel_project.lake_side_hotel.repository.RoleRepository;
import com.hotel_project.lake_side_hotel.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @Override
    public User registerUser(User user){
        if (userRepository.existByEmail(user.getEmail())){
            throw new UserAlreadyExistsException(user.getEmail() + "already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(userRole));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}

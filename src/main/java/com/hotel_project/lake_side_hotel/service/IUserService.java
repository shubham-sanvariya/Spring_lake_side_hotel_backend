package com.hotel_project.lake_side_hotel.service;

import com.hotel_project.lake_side_hotel.exception.UserAlreadyExistsException;
import com.hotel_project.lake_side_hotel.model.User;

import java.util.List;

public interface IUserService {
    User registerUser(User user);
    List<User> getUsers();
    void deleteUser(String email);
    User getUser(String email);
}

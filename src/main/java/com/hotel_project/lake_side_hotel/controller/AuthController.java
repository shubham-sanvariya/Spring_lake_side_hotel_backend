package com.hotel_project.lake_side_hotel.controller;

import com.hotel_project.lake_side_hotel.exception.UserAlreadyExistsException;
import com.hotel_project.lake_side_hotel.model.User;
import com.hotel_project.lake_side_hotel.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
public class AuthController {
    private final IUserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(User user){
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User Registered successfully");
        }catch (UserAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
}

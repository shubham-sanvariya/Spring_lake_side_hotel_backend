package com.hotel_project.lake_side_hotel.security.user;

import com.hotel_project.lake_side_hotel.exception.RoleAlreadyExistsException;
import com.hotel_project.lake_side_hotel.model.Role;
import com.hotel_project.lake_side_hotel.service.IRoleService;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.FOUND;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles(){
        return new ResponseEntity(roleService.getRoles(), FOUND);
    }
}

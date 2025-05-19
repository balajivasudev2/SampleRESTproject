package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "API Operations", description = "performing CRUD")

public class UserController {

    @Autowired
    UserService userservice;

    @PostMapping("/send")

    @Operation(summary = "send the details", description = "sending the details to DB.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successfully sent"),
            @ApiResponse(responseCode = "404", description = "request denied")})

    public User saveUserData(@RequestBody User user) {

        return userservice.create(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getDetails(@PathVariable long id) {
        return userservice.findDetailsById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateDetails(@PathVariable long id, @RequestBody User user) {

        User update = userservice.updateDetailsById(id, user);
        return ResponseEntity.ok(update);
    }

}

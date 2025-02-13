package com.example.schedules.controller;

import com.example.schedules.dto.UserRequestDto;
import com.example.schedules.dto.UserResponseDto;
import com.example.schedules.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody @Valid UserRequestDto userRequest) {
        User user = userService.registerUser(userRequest.getUsername(), userRequest.getEmail(), userRequest.getPassword());
        UserResponseDto responseDto = new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}

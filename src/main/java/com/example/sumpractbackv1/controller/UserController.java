package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.UserRequest;
import com.example.sumpractbackv1.model.dto.search.UserSearchCriteria;
import com.example.sumpractbackv1.model.entity.User;
import com.example.sumpractbackv1.service.controllersServices.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ResponseDto<User>> searchUsers(@Valid UserSearchCriteria criteria) {
        ResponseDto<User> result = userService.searchUsers(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> saveUser(@Valid @RequestBody UserRequest user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var new_user = userService.create(user.toUser());
        if (new_user == null) {
            return new ResponseEntity<>("User with this username already exists", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new_user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        if (!userService.existsUserById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

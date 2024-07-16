package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.UserSearchCriteria;
import com.example.sumpractbackv1.model.entity.User;
import com.example.sumpractbackv1.service.controllersServices.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto<User>> searchUsers(@Valid UserSearchCriteria criteria) {
        ResponseDto<User> result = userService.searchUsers(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //TODO логику для прокидывания родителя и дочерних

    @PutMapping("/save")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        if (!userService.existsUserById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

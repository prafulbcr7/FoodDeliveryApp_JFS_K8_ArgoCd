package com.myApplication.userInformation.controller;

import com.myApplication.userInformation.dto.UserDTO;
import com.myApplication.userInformation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userdto){
        UserDTO addedUser= userService.addUser(userdto);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> allUsersList = userService.getAllUsers();
        return new ResponseEntity<>(allUsersList, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }

}

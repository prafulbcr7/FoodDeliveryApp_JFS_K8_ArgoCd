package com.myApplication.userInformation.service;

import com.myApplication.userInformation.dto.UserDTO;
import com.myApplication.userInformation.entity.User;
import com.myApplication.userInformation.mapper.UserMapper;
import com.myApplication.userInformation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserDTO addUser(UserDTO userdto){
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOtoUser(userdto));
        return UserMapper.INSTANCE.mapuserToUserDTO(savedUser);
    }

    public List<UserDTO> getAllUsers(){
        List<User> listOfUsers = userRepo.findAll();
        List<UserDTO> listOfUserDTOs = listOfUsers.stream().map(i -> UserMapper.INSTANCE.mapuserToUserDTO(i)).collect(Collectors.toList());
        return listOfUserDTOs;
    }

    public ResponseEntity<UserDTO> getUserById(Integer id){
        Optional<User> op = userRepo.findById(id);
        if(op.isPresent()){
            UserDTO userdtoDetails = UserMapper.INSTANCE.mapuserToUserDTO(op.get());
            return new ResponseEntity<>(userdtoDetails, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

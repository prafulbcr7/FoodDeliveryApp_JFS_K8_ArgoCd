package com.myApplication.userInformation.mapper;

import com.myApplication.userInformation.dto.UserDTO;
import com.myApplication.userInformation.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOtoUser(UserDTO userDTO);

    UserDTO mapuserToUserDTO(User user);
}

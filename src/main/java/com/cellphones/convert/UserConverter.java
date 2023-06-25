package com.cellphones.convert;

import com.cellphones.dto.UserDTO;
import com.cellphones.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setFullName(userEntity.getFullName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setStatus(userEntity.getStatus());
        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
        List<String> list = new ArrayList<>();
        userEntity.getRoles().stream().forEach(role->
                list.add(role.getName()));
        userDTO.setRoles(list);
        if (userEntity.getCreateDate() != null) {
            userDTO.setCreateDate(userEntity.getCreateDate());

        } else if (userEntity.getCreateBy() != null) {
            userDTO.setCreateBy(userEntity.getCreateBy());
        }

        return userDTO;
    }

    public static UserDTO toUserDTO(UserDTO olduser, UserDTO newUser) {


        newUser.setId(olduser.getId());
        newUser.setEmail(olduser.getEmail());
        newUser.setUsername(olduser.getUsername());
        newUser.setFullName(olduser.getFullName());
        newUser.setPassword(olduser.getPassword());
        newUser.setStatus(olduser.getStatus());
        newUser.setPhoneNumber(olduser.getPhoneNumber());
        if (olduser.getCreateDate() != null) {
            newUser.setCreateDate(olduser.getCreateDate());
        }
        if (olduser.getCreateBy() != null) {
            newUser.setCreateBy(olduser.getCreateBy());
        }
        return newUser;
    }

    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setStatus(userDTO.getStatus());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());

        if (userDTO.getCreateDate() != null) {
            userEntity.setCreateDate(userDTO.getCreateDate());

        }
        if (userDTO.getCreateBy() != null) {
            userEntity.setCreateBy(userDTO.getCreateBy());
        }
        return userEntity;


    }
}

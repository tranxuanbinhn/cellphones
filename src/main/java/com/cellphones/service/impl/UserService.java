package com.cellphones.service.impl;

import com.cellphones.convert.UserConverter;
import com.cellphones.dto.UserDTO;
import com.cellphones.entity.RoleEntity;
import com.cellphones.entity.UserEntity;
import com.cellphones.repository.RoleRepository;
import com.cellphones.repository.UserRepository;
import com.cellphones.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;



    public UserDTO findUserById(Long id)
    {
        UserEntity user = userRepository.findOneById(id);
        return UserConverter.toUserDTO(user);
    }

    @Override
    public List<UserDTO> findAll(Pageable page) {
        List<UserEntity> listEntities = userRepository.findAll(page).getContent();
        List<UserDTO> listDto = new ArrayList<>();
        for (UserEntity entities:listEntities) {
            listDto.add(UserConverter.toUserDTO(entities));
        }
        return listDto;
    }

    @Override
    public boolean existsByUsername(String usename) {
        return userRepository.existsByUsername(usename);
    }

    @Override
    public boolean existsByNumberphone(String phonenumber) {

        if(phonenumber==null)
        {
            return false;
        }
        else
        {
            return userRepository.existsByPhoneNumber(phonenumber);
        }


    }

    @Override
    public boolean existsByEmail(String email) {
       if(email==null)
       {
           return false;
       }
       else
       {
           return userRepository.existsByEmail(email);
       }
    }

    @Override
    public UserDTO save(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();

        if(userDTO.getId() == null)
        {
            userEntity.setStatus(1);
            userEntity = UserConverter.toUserEntity(userDTO);
        }
        else if(userDTO.getId() != null)
        {
            UserDTO oldUser = findUserById(userDTO.getId());
           UserDTO  newUser = new UserDTO();
            newUser = UserConverter.toUserDTO(userDTO,oldUser);
            userEntity = UserConverter.toUserEntity(newUser);

        }
        List<RoleEntity> listRoles = new ArrayList<>();
        if(userDTO.getRoles()==null)
        {
            listRoles.add(roleRepository.findRoleEntityByName("ROLE_USER"));

        }
        else
        {
            userDTO.getRoles().forEach(role->
                    listRoles.add(roleRepository.findRoleEntityByName(role))

            );

        }

        userEntity.setStatus(1);
        userEntity.setRoles(listRoles);

        
//        for (RoleEntity role : listRoles) {
//            userEntity.getRoles().add(role);
//        }
        //
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return UserConverter.toUserDTO(userRepository.save(userEntity));
    }

    @Override
    public long countPage() {
        return userRepository.count();
    }

    @Override
    public void Delete(List<Long> ids) {
        for (long id:ids) {
            userRepository.deleteById(id);
        }
    }
    /*
    "username":"admin0101",
            "email":"admin01010@gmail.com",
            "password":"1231394561",
            "roles":["ROLE_ADMIN"]*/
}

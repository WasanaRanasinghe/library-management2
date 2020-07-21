/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.service;


import com.example.librarymanagement.model.domains.LibraryUserDTO;
import com.example.librarymanagement.model.persistance.LibraryUser;
import com.example.librarymanagement.repository.UserRepository;
import com.example.librarymanagement.util.ObjectMapperUtils;
import java.util.List;

import com.example.librarymanagement.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Wasana
 */
@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();
    
    public String login(LibraryUserDTO userDto){

        String message = "";

        try{
            LibraryUser user = userRepository.findByUserName(userDto.getUserName());
            if(user.getPassword().equals(userDto.getPassword()))
                if(user.getUserRoleId().getUserRoleId() == 1){ //admin
                    message = "admin";
                }else if(user.getUserRoleId().getUserRoleId() == 2){
                    message = "user";
                }
            else
                message = "incorrect password";
        }catch (Exception e){
            e.printStackTrace();
            message = "user not found";
        }
        return message;
    }

    public List<LibraryUser> listAll(){
        List<LibraryUser> allUsers = userRepository.findAll();
        List<LibraryUserDTO> allDtoUsers = ObjectMapperUtils.mapAll(allUsers,LibraryUserDTO.class);
        return userRepository.findAll();
    }

    public List<LibraryUser> listUserByRoleId(Long id){
        return userRepository.findByUserRoleId(id);
    }
    
    public int save(LibraryUserDTO userDTO){
        LibraryUser user = modelMapper.map(userDTO, LibraryUser.class);
        if (user.getUserId()==null){ //check whether user creation or update
            List <LibraryUser> userlist = userRepository.findAllByUserName(user.getUserName());
            if (userlist.size() == 0){
                user.setState(1);
                userRepository.save(user);
            }
            else{
                user.setState(2); //user name exist
            }
        }
        else{
            user.setState(3); //successfully updated
            userRepository.save(user);

        }
        return user.getState();
    }

    public LibraryUserDTO get(Long id){
        LibraryUser user = userRepository.findById(id).get();
        LibraryUserDTO userDto = modelMapper.map(user, LibraryUserDTO.class);
        return userDto;
    }
    
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}

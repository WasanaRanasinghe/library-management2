package com.example.librarymanagement.service;

import com.example.librarymanagement.model.persistance.UserRole;
import com.example.librarymanagement.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    public void save(UserRole userrole){
        userRoleRepository.save(userrole);
    }

    public List<UserRole> getAllRoles(){
        return userRoleRepository.findAll();
    }
}

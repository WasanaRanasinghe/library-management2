/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.persistance.LibraryUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Wasana
 */
public interface UserRepository  extends JpaRepository<LibraryUser, Long>{


    public List<LibraryUser> findAllByUserName(String userName);
    public LibraryUser findByUserName(String username);
    public List<LibraryUser> findByUserRoleId(Long id);


}

package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.persistance.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}

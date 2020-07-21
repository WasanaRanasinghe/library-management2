/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.model.persistance;

import javax.persistence.*;

/**
 *
 * @author Wasana
 */
@Entity
public class LibraryUser {
    
    public LibraryUser(){}
    
    public LibraryUser(String firstName, String lastName, String address, Status statusCode, UserRole userRoleId, String userName, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.statusCode = statusCode;
        this.userRoleId = userRoleId;
        this.userName = userName;
        this.password = password;
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String address;
    @Column(unique = true)
    private String userName;
    private String password;

    @ManyToOne
    private Status statusCode;
    @ManyToOne
    private UserRole userRoleId;
    private int state;

/*    state
 1 - successfully created
 2 - already exist
 3 - successfully updated
 4 - successfully deleted
 5 - update failed
 6 - delete failed*/

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getUserStatus() {
        return statusCode;
    }

    public void setUserStatus(Status userStatus) {
        this.statusCode = userStatus;
    }

    public UserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UserRole userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

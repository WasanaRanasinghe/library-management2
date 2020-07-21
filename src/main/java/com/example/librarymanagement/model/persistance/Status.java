/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.model.persistance;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Wasana
 */
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusCode;
    private String statusDescription;

    @OneToMany(mappedBy = "statusCode")
    private List<LibraryUser> user;

    @OneToMany(mappedBy = "availabilityStatus")
    private List<Status> availabilityStatus;

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public Long getStatusCode() {
        return statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }
    
    
    
}

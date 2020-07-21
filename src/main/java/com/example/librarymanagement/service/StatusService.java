package com.example.librarymanagement.service;

import com.example.librarymanagement.model.persistance.Status;
import com.example.librarymanagement.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public void save(Status status){
        statusRepository.save(status);
    }

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public Status getStatusById(long id){
        return statusRepository.findStatusByStatusCode(id);
    }
}

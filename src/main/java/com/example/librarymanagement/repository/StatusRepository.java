package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.persistance.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {

    public Status findStatusByStatusCode(long id);
}

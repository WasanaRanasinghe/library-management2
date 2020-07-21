package com.example.librarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class LibraryManagementApplication {

    private static final Logger log = LoggerFactory.getLogger(LibraryManagementApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }



}
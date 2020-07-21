/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.persistance.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author Wasana
 */
public interface BookRepository extends JpaRepository<Book, Long>{
    @Query(value = "select * from book b where b.book_title like %:keyword%", nativeQuery = true)
    List<Book> findByKeyword(@Param("keyword") String keyword);
    
    
}

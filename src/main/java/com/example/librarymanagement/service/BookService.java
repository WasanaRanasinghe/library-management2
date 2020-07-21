/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.service;

import com.example.librarymanagement.model.domains.BookDTO;
import com.example.librarymanagement.model.persistance.Book;
import com.example.librarymanagement.repository.BookRepository;
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
public class BookService {

    @Autowired
    private BookRepository repo;
    ModelMapper modelMapper = new ModelMapper();


    public List<BookDTO> getAllBooks() {
        List<Book> allbooks = repo.findAll();
        List<BookDTO> allDtoBooks = ObjectMapperUtils.mapAll(allbooks,BookDTO.class);
        return allDtoBooks;
    }

    public List<BookDTO> findByKeyword(String keyword){
        List<Book> allbooks = repo.findByKeyword(keyword);
        List<BookDTO> filteredDtoBooks = ObjectMapperUtils.mapAll(allbooks,BookDTO.class);
        return filteredDtoBooks;
    }

    public void save(BookDTO bookdto) {
        Book book = modelMapper.map(bookdto, Book.class);
        repo.save(book);
    }

    public BookDTO getBookById(Long id) {
        Book book = repo.findById(id).get();
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        return bookDTO;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.domains.BookDTO;
import com.example.librarymanagement.model.persistance.Book;
import com.example.librarymanagement.model.persistance.Status;
import com.example.librarymanagement.service.BookService;

import java.util.List;

import com.example.librarymanagement.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Wasana
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private StatusService statusService;

    @RequestMapping("/books")
    public String viewBookListAdmin(Model model, String keyword) {
        if (keyword != null) {
            List<BookDTO> allBooks = bookService.findByKeyword(keyword);
            model.addAttribute("allBooks", allBooks);
        } else {
            List<BookDTO> allBooks = bookService.getAllBooks();
            model.addAttribute("allBooks", allBooks);
        }
        return "manage_book";
    }

    @RequestMapping("/viewbooks")
    public String viewBookList(Model model, String keyword) {
        if (keyword != null) {
            List<BookDTO> allBooks = bookService.findByKeyword(keyword);
            model.addAttribute("allBooks", allBooks);
        } else {
            List<BookDTO> allBooks = bookService.getAllBooks();
            model.addAttribute("allBooks", allBooks);
        }
        return "view_book";
    }

    @RequestMapping("/add-book-form")
    public String addBookForm(Model model) {
        model.addAttribute("newBook", new Book());
        List<Status> status = statusService.getAllStatus();
        model.addAttribute("status", status);
        return "new_book";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("newBook") BookDTO newBook) {
        bookService.save(newBook);
        return "redirect:/books";
    }

    @RequestMapping(value = "/borrow", method = RequestMethod.POST)
    public String borrowBook(@ModelAttribute("newBook") BookDTO borrowedBook) {
        borrowedBook.setAvailabilityStatus(statusService.getStatusById(4));
        bookService.save(borrowedBook);
        return "redirect:/viewbooks";
    }

    @RequestMapping("/edit-book-form/{bookId}")
    public ModelAndView editBookForm(@PathVariable(name = "bookId") Long id) {
        ModelAndView mav = new ModelAndView("edit_book");
        BookDTO book = bookService.getBookById(id);
        mav.addObject("book", book);
        List<Status> bookstatus = statusService.getAllStatus();
        mav.addObject("bookstatus", bookstatus);
        return mav;
    }

    @RequestMapping("/borrow/{bookId}")
    public ModelAndView borrowBookForm(@PathVariable(name = "bookId") Long id) {
        ModelAndView mav = new ModelAndView("borrow_book");
        BookDTO book = bookService.getBookById(id);
        mav.addObject("book", book);
        List<Status> bookstatus = statusService.getAllStatus();
        mav.addObject("bookstatus", bookstatus);
        return mav;
    }

    @RequestMapping("/delete-book/{bookId}")
    public String delete(@PathVariable(name = "bookId") Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}

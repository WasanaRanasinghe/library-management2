/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.LoginForm;
import com.example.librarymanagement.model.domains.LibraryUserDTO;
import com.example.librarymanagement.model.persistance.LibraryUser;
import com.example.librarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Wasana
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login-form", method = RequestMethod.GET)
    public String getLoginform(Model model){
        model.addAttribute("loginformuser", new LoginForm());
        return "login";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomepage(Model model){
        model.addAttribute("loginformuser", new LoginForm());
        return "home";
    }
    @RequestMapping(value = "/loginuser", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginformuser") LibraryUserDTO userDto, Model model){
        String message = userService.login(userDto);
        if (message == "user")
            return "redirect:/viewbooks";
        else if(message == "admin")
            return "redirect:/home";
        else
            return "login";
    }

}

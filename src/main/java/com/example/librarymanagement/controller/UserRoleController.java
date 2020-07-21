package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.persistance.UserRole;
import com.example.librarymanagement.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserRoleController {
    @Autowired
    private UserRoleService service;

    @RequestMapping("/add-user-role-form")
    public String addUserRoleForm(Model model){
        UserRole newuserRole = new UserRole();
        model.addAttribute("newUserRole", newuserRole);
        return "new_user_role";
    }

    @RequestMapping(value = "/userRole", method = RequestMethod.POST)
    public String addUserRole(@ModelAttribute("newUserRole") UserRole newUserRole){
        service.save(newUserRole);
        return "redirect:/users";

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.domains.BookDTO;
import com.example.librarymanagement.model.domains.LibraryUserDTO;
import com.example.librarymanagement.model.persistance.LibraryUser;
import com.example.librarymanagement.model.persistance.Status;
import com.example.librarymanagement.model.persistance.UserRole;
import com.example.librarymanagement.service.StatusService;
import com.example.librarymanagement.service.UserRoleService;
import com.example.librarymanagement.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wasana
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService roleService;

    @Autowired
    private StatusService statusService;
    
    @RequestMapping("/users")
    public String viewUserList(Model model, Long roleId){
        System.out.println(roleId);
        if (roleId != null){
            model.addAttribute("allUsers",userService.listUserByRoleId(roleId));
        }
        else{
            model.addAttribute("allUsers", userService.listAllUsers());
        }

        return "view_users";
    }

    @RequestMapping("/roles")
    public String viewAllRoles(Model model){
        List<UserRole> userRole = roleService.getAllRoles();
        model.addAttribute("allRoles", userRole);
        return "view_users";
    }

    @RequestMapping("/add-user-form")
    public String addUserForm(Model model){
        model.addAttribute("newUser", new LibraryUserDTO());
        model.addAttribute("roles" , roleService.getAllRoles());
        model.addAttribute("userstatus" , statusService.getAllStatus());
        return "new_user";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("newUser") LibraryUserDTO newUser){
        int state = 0;
        state = userService.save(newUser);
       String viewUrl = "redirect:/add-user-form";
        if(state == 1 || state == 3 || state == 4) {
            viewUrl ="redirect:/users";
        }else if (state == 2){
            viewUrl = "redirect:/add-user-form";
        }else if(state == 5){
            viewUrl = "redirect:/edit-user-form" + newUser.getUserId();
        }
        return viewUrl;
    }
    
    @RequestMapping("/edit-user-form/{userId}")
    public ModelAndView editUserForm(@PathVariable(name = "userId")Long id){
        ModelAndView mav = new ModelAndView("edit_user");
        LibraryUserDTO user = userService.get(id);
        mav.addObject("user", user);
        List<UserRole> role = roleService.getAllRoles();
        mav.addObject("roles",role);
        List<Status> userstatus = statusService.getAllStatus();
        mav.addObject("userstatus",userstatus);
        return mav;
    }

    @RequestMapping("/delete-user-form/{userId}")
    public ModelAndView deleteUserForm(@PathVariable(name = "userId")Long id){
        ModelAndView mav = new ModelAndView("delete_user_form");
        LibraryUserDTO user = userService.get(id);
        mav.addObject("user", user);
        List<UserRole> role = roleService.getAllRoles();
        mav.addObject("roles",role);
        List<Status> userstatus = statusService.getAllStatus();
        mav.addObject("userstatus",userstatus);
        return mav;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("deleteUser") LibraryUserDTO deletedUser) {
        deletedUser.setUserStatus(statusService.getStatusById(5));
        userService.save(deletedUser);
        return "redirect:/users";
    }
}

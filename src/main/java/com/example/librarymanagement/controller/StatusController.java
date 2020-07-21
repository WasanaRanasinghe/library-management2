package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.persistance.Status;
import com.example.librarymanagement.model.persistance.UserRole;
import com.example.librarymanagement.service.StatusService;
import com.example.librarymanagement.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatusController {
    @Autowired
    private StatusService statusService;

    @RequestMapping("/add-status-form")
    public String addStatusForm(Model model){
        Status newStatus = new Status();
        model.addAttribute("newStatus", newStatus);
        return "new_status";
    }

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public String addUserRole(@ModelAttribute("newStatus") Status status){
        statusService.save(status);
        return "redirect:/users";

    }
}

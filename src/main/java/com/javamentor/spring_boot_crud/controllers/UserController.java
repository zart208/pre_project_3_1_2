package com.javamentor.spring_boot_crud.controllers;

import com.javamentor.spring_boot_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("It's Hello-page of Spring MVC-SECURITY application");
        messages.add("author: Zakharov Artem ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @GetMapping(value = "/user")
    public String printUserPage(Principal principal, ModelMap model) {
        model.addAttribute("user", userService.getByName(principal.getName()));
        return "user";
    }

    @GetMapping(value = "/admin")
    public String printAdminPage(Principal principal, ModelMap model) {
        model.addAttribute("user", userService.getByName(principal.getName()));
        return "admin";
    }

    @GetMapping(value = "login")
    public String loginPage() {
        return "login";
    }
}
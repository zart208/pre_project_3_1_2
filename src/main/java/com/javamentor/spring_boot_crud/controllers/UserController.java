package com.javamentor.spring_boot_crud.controllers;

import com.javamentor.spring_boot_crud.models.User;
import com.javamentor.spring_boot_crud.services.RoleService;
import com.javamentor.spring_boot_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/")
    public String printWelcome(@ModelAttribute("user") User user, Principal principal, ModelMap model) {
        if (principal != null) {
            model.addAttribute("currentUser", userService.getByName(principal.getName()));
        }
        model.addAttribute("usersList", userService.getAll());
        model.addAttribute("rolesList", roleService.getAll());
        return "index";
    }

    @PostMapping("/")
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("users/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.get(id));
        model.addAttribute("roleList", roleService.getAll());
        return "/users/edit";
    }

    @GetMapping("users/{id}/change_password")
    public String changePassword(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "/users/change_password";
    }

    @PutMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

//    @GetMapping(value = "/user")
//    public String printUserPage(Principal principal, ModelMap model) {
//        model.addAttribute("user", userService.getByName(principal.getName()));
//        return "redirect: /";
//    }
//
//    @GetMapping(value = "/admin")
//    public String printAdminPage(Principal principal, ModelMap model) {
//        model.addAttribute("user", userService.getByName(principal.getName()));
//        return "redirect: /";
//    }
//
//    @GetMapping(value = "login")
//    public String loginPage() {
//        return "redirect: /";
//    }
}
package com.test.hplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("newuser") User user, Model model) {
        System.out.println("in registration controller");
        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }

}

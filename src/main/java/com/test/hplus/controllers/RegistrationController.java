package com.test.hplus.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model) {
        System.out.println("in registration controller");
        if (result.hasErrors()) {
            return "register";
        }
        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }

}

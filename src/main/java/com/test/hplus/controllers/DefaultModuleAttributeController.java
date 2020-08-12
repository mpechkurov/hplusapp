package com.test.hplus.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
@ControllerAdvice
public class DefaultModuleAttributeController {

    @ModelAttribute("newuser")
    public User getDefaultUser() {
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems() {
        return Arrays.asList(new String[] { "Male", "Female", "Other" });
    }

    @ModelAttribute("login")
    public Login getDefaultLogin() {
        return new Login();
    }
}

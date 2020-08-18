package com.test.hplus.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("Ending user session");
        session.invalidate();
        //this is not possible here will throw an error
        // System.out.println(session.getAttribute("login"));
        return "login";
    }
}

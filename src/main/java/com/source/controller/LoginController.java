package com.source.controller;


import com.source.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Locale locale, Model model) {

        return "form_login";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied() {

        return "access_denied";

    }


}

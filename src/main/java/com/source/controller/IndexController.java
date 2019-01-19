package com.source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String home(Locale locale, Model model) {

        return "index";
    }
}

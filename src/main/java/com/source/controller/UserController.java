package com.source.controller;


import com.source.model.entity.Client;
import com.source.model.entity.User;
import com.source.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth")
    public String authentication(Model model) {
        model.addAttribute("user", new User());
        return "form_login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") User tempUser,
                        BindingResult bindingResult, Model model) {

        Optional<User> optionalUser = userService
                .getByLoginAndPassword(tempUser.getLogin(), tempUser.getPassword());
        if (bindingResult.hasErrors()) {
            return "form_login";
        } else {
            if (optionalUser.isPresent()) {
                Client client = optionalUser.get().getClient();
                model.addAttribute("client", client); // TODO add client to session context

            } else {
                return "form_login";
            }
        }
        return "forward:/client/welcome"; //TODO forward не показывает /client/welcome в адресной строке
    }


    @InitBinder    // is a pre-processor method.
    public void initBinder(WebDataBinder dataBinder) {
        // remove leading and trailing whitespace
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}

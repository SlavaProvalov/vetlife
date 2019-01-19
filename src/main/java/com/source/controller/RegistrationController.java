package com.source.controller;


import com.source.model.entity.User;
import com.source.model.service.RoleService;
import com.source.model.service.UserService;
import com.source.model.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@SessionAttributes
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/registrationForm")
    public String registrationForm(Model model) {

        model.addAttribute("userRoles", roleService.getAll());
        model.addAttribute("crmUser", new CrmUser());

        return "registration_form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser crmUser,
            BindingResult bindingResult,
            Model model) {

        String userName = crmUser.getUserName();

        if (bindingResult.hasErrors()) {
            return "registration_form";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("registrationError", "User name already exists."); // TODO localize

            return "registration_form";
        }
        // create user account
        userService.save(crmUser);

        return "registration_confirmation";
    }
}

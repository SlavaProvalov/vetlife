package com.source.controller;

import com.source.model.entity.Client;
import com.source.model.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public String listClients(Model model) {
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);

        return "list_clients";
    }

    @RequestMapping("/welcome")
    public String welcome(/*@RequestParam("user") User user, @RequestParam("client") Client client,*/ Model model) {
//        model.addAttribute("user", user);
//        model.addAttribute("client", client);

        return "client_page";
    }
}

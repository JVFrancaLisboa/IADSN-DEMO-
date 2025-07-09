package com.iadsn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiscController {

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping("/contrato")
    public String getContrato() {
        return "fragments/contrato";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
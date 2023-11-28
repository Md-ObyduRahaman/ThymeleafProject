package com.tsports.Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/login2"})
    public String loginPage(){
        System.out.println("Sojib");
        return "login";
    }
}

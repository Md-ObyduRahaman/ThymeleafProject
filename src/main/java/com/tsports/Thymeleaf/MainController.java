package com.tsports.Thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@Controller
public class MainController {

    @Autowired
     MsqlDataRepo msqlDataRepo;



    @GetMapping(value = {"/login"})
    public String loginPage(Model model){
        System.out.println("Sojib");
        return "loginPage";
    }
   @PostMapping("/login")
    public String dashBoard(@RequestParam(name = "email") String email,
                            @RequestParam(name = "password") String password)
    {

        UserInformationManager userManager = new UserInformationManager();
        boolean isValid = userManager.isValidUser(email, password);

        if (isValid) {
            System.out.println("Login successful!");
            return  "dashBoaard";
        } else {


            return "redirect:/login?error=true";
        }

    }
    @PostMapping("/mainPage")
    public String main(@ModelAttribute("emailOrPhone") EmailOrPhone emailOrPhone,Model model) throws Exception {
        System.out.println(emailOrPhone.getEmailOrPhone());

        model.addAttribute("dataList", msqlDataRepo.getMsqlData(emailOrPhone.getEmailOrPhone()));

        return "main";
    }
}

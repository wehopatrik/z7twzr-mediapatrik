package hu.mik.prog5.z7twzr.mediapatrik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("home")
    public String getHomePage() {
        return "home";
    }
}

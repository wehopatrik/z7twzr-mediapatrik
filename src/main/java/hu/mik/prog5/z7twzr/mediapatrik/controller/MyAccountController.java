package hu.mik.prog5.z7twzr.mediapatrik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyAccountController {

    @GetMapping("my-account")
    public String getMyAccountPage() {
        return "myaccount";
    }

}

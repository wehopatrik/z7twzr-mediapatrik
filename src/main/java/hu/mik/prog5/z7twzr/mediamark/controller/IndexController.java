package hu.mik.prog5.z7twzr.mediamark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("index")
    public String getIndexPage() {
        return "index";
    }

}

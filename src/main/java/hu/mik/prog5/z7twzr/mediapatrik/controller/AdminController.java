package hu.mik.prog5.z7twzr.mediapatrik.controller;

import hu.mik.prog5.z7twzr.mediapatrik.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ProductService productService;

    @GetMapping("admin")
    public String getAdminPage(Model model) {
        model.addAttribute("orderedProducts", productService.findAllOrders());
        return "admin";
    }

}

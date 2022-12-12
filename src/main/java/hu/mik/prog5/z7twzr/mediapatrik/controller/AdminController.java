package hu.mik.prog5.z7twzr.mediapatrik.controller;

import hu.mik.prog5.z7twzr.mediapatrik.entity.Product;
import hu.mik.prog5.z7twzr.mediapatrik.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ProductService productService;

    @GetMapping("admin")
    public String getAdminPage(Model model) {
        List<Product> orderedProducts = productService.findAllOrders();

        int countedPrice = 0;
        for(Product product : orderedProducts) {
            countedPrice += product.getPrice();
        }

        model.addAttribute("orderedProducts", orderedProducts);
        model.addAttribute("countedPrice", countedPrice);
        return "admin";
    }

}

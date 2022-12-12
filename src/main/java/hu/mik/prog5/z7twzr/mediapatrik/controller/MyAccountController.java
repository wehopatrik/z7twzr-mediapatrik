package hu.mik.prog5.z7twzr.mediapatrik.controller;

import hu.mik.prog5.z7twzr.mediapatrik.entity.Product;
import hu.mik.prog5.z7twzr.mediapatrik.entity.User;
import hu.mik.prog5.z7twzr.mediapatrik.service.ProductService;
import hu.mik.prog5.z7twzr.mediapatrik.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyAccountController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping("my-account")
    public String getMyAccountPage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);

        List<Product> orderedProducts = productService.findAllOrdersByUser(user.getId());

        int countedPrice = 0;
        for(Product product : orderedProducts) {
            countedPrice += product.getPrice();
        }

        model.addAttribute("orderedProducts", orderedProducts);
        model.addAttribute("countedPrice", countedPrice);
        return "myaccount";
    }

}

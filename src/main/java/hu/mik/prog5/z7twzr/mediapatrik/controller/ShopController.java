package hu.mik.prog5.z7twzr.mediapatrik.controller;

import hu.mik.prog5.z7twzr.mediapatrik.entity.Product;
import hu.mik.prog5.z7twzr.mediapatrik.entity.User;
import hu.mik.prog5.z7twzr.mediapatrik.service.ProductService;
import hu.mik.prog5.z7twzr.mediapatrik.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping("shop")
    public String getShopPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @PostMapping("shop")
    @ResponseBody
    public String shop(@RequestBody Product product, Model model) {
        try {
            // Termék kikérése
            Product foundProductInDb = productService.findById(product.getId());

            // Felhasználó kikérése
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findByUsername(username);

            // Rendelés
            boolean isSuccessful = productService.order(foundProductInDb.getId(), user.getId());
            if(!isSuccessful) {
                return "Error";
            }

            log.info("PRODUCT ORDERED: " + foundProductInDb.toString());
            return "Done";
        } catch(Exception e) {
            log.error("ERROR HAPPENED WHEN ORDERING PRODUCT: " + product.toString() + " | ERROR: " + e);
            return "Error";
        }
    }

}

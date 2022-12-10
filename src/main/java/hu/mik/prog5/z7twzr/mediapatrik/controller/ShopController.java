package hu.mik.prog5.z7twzr.mediapatrik.controller;

import hu.mik.prog5.z7twzr.mediapatrik.entity.Product;
import hu.mik.prog5.z7twzr.mediapatrik.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("shop")
    public String getShopPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @PostMapping("shop")
    @ResponseBody
    public String shop(@RequestBody Product product, Model model) {
        try {
            Product foundProductInDb = productService.findById(product.getId());
            log.info("PRODUCT ORDERED: " + foundProductInDb.toString());
            return "Done";
        } catch(Exception e) {
            log.error("ERROR HAPPENED WHEN ORDERING PRODUCT: " + product.toString() + " | ERROR: " + e);
            return "Error";
        }
    }

}

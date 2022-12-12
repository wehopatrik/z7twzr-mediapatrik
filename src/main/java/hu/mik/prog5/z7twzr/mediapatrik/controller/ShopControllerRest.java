package hu.mik.prog5.z7twzr.mediapatrik.controller;

import hu.mik.prog5.z7twzr.mediapatrik.MediaPatrikApplication;
import hu.mik.prog5.z7twzr.mediapatrik.entity.Product;
import hu.mik.prog5.z7twzr.mediapatrik.entity.ProductType;
import hu.mik.prog5.z7twzr.mediapatrik.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RolesAllowed("ROLE_ADMIN")
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ShopControllerRest {

    private final ProductService productService;

    @GetMapping(value = "product-types", consumes = MediaType.ALL_VALUE)
    public ProductType[] listTypes() {
        return ProductType.values();
    }

    @GetMapping(value = "products", consumes = MediaType.ALL_VALUE)
    public List<Product> listProducts() {
        return this.productService.findAll();
    }

}

package hu.mik.prog5.z7twzr.mediapatrik.controller;

import hu.mik.prog5.z7twzr.mediapatrik.entity.User;
import hu.mik.prog5.z7twzr.mediapatrik.service.ProductService;
import hu.mik.prog5.z7twzr.mediapatrik.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MyAccountController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping("my-account")
    public String getMyAccountPage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);

        model.addAttribute("orderedProducts", productService.findAllOrdersByUser(user.getId()));
        return "myaccount";
    }

}

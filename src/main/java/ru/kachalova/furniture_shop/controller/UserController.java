package ru.kachalova.furniture_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kachalova.furniture_shop.domain.Category;
import ru.kachalova.furniture_shop.domain.Human;
import ru.kachalova.furniture_shop.domain.Product;
import ru.kachalova.furniture_shop.domain.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kachalova.furniture_shop.repos.CategoryRepo;
import ru.kachalova.furniture_shop.repos.ProductRepo;

@Controller
public class UserController {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @GetMapping("/personalArea")
    public String personalArea(Model model) {
        Human userFromDb = (Human) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

        model.addAttribute("human", userFromDb);

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().contains(Role.ADMIN)) {
            model.addAttribute("userList",true);
            return "personalArea";
        }
        else{
            if(authentication.getAuthorities().contains(Role.USER)){
                model.addAttribute("purchase",true);
                return "personalArea";
            }
            else return "redirect:/login";
        }
    }

    @GetMapping("/product/{product}")
    public String openProduct(@PathVariable Product product, Model model){
        model.addAttribute("product", product);
        return "watchProduct";
    }
}

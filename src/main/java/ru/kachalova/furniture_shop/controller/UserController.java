package ru.kachalova.furniture_shop.controller;

import ru.kachalova.furniture_shop.domain.Human;
import ru.kachalova.furniture_shop.domain.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
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
}

package ru.kachalova.furniture_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kachalova.furniture_shop.domain.Human;
import ru.kachalova.furniture_shop.repos.UserRepo;
import ru.kachalova.furniture_shop.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid Human user, Model model) {
        Human userFromDb = userRepo.findByUsername(user.getUsername());

       /* if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }*/
        if (!userService.addUser(user)) {
            //model.addAttribute("usernameError", "User exists!");
            return "registration";
        }
        /*user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
*/
        return "redirect:/login";
    }
}
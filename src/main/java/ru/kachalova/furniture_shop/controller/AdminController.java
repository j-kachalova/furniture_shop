package ru.kachalova.furniture_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kachalova.furniture_shop.domain.Category;
import ru.kachalova.furniture_shop.domain.Human;
import ru.kachalova.furniture_shop.domain.Product;
import ru.kachalova.furniture_shop.domain.Role;
import ru.kachalova.furniture_shop.repos.CategoryRepo;
import ru.kachalova.furniture_shop.repos.ProductRepo;
import ru.kachalova.furniture_shop.repos.UserRepo;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
public class AdminController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${disk}")
    private String disk;


    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Product> products = productRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            products = productRepo.findByName(filter);
        } else {
            products = productRepo.findAll();
        }

        Iterable<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("filter", filter);

        return "main";
    }


    @RequestMapping(value = "/main", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addProduct(
           @RequestParam String name,
            @RequestParam Integer price,
            @RequestParam Integer amount,
            @RequestParam String description,
           @RequestParam String categoryP,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model
    ) throws IOException {

       Product product = new Product(name, price, amount);

        if (file != null && !file.getOriginalFilename().isEmpty()) {

            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }


            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(disk+uploadPath + "/" + resultFilename));

            product.setFilename(resultFilename);
        }
        Category category = categoryRepo.findByName(categoryP).get(0);
        product.setCategory(category);
        productRepo.save(product);

        Iterable<Category> categories = categoryRepo.findAll();
        model.put("categories", categories);

        Iterable<Product> products = productRepo.findAll();
        model.put("products", products);

        return "main";
    }
    @GetMapping("/user")
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());

        return "userList";
    }
    @GetMapping("/user/{user}")
    public String userEditForm(@PathVariable Human user, Model model) {
        System.out.println(user);
        model.addAttribute("human", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping("/user")
    public String userSave(
            @RequestParam String username,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") Human user
    ) {
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setPatronymic(patronymic);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);

        return "redirect:/user";
    }

    @GetMapping("/main/delete/{product}")
    public String deleteProduct(@PathVariable Product product) {
        productRepo.delete(product);
        return "redirect:/main";
    }
    @GetMapping("/main/edit/{product}")
    public String editProduct(@PathVariable Product product, Model model){
        model.addAttribute("product",product);
        return "editProduct";
    }

}

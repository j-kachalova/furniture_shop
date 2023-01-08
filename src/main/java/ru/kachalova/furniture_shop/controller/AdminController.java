package ru.kachalova.furniture_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kachalova.furniture_shop.domain.Product;
import ru.kachalova.furniture_shop.repos.ProductRepo;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class AdminController {
    @Autowired
    private ProductRepo productRepo;

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

        model.addAttribute("products", products);
        model.addAttribute("filter", filter);

        return "main";
    }


    @RequestMapping(value = "/main", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String add(
           @RequestParam String name,
            @RequestParam Integer price,
            @RequestParam Integer amount,
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

        productRepo.save(product);

        Iterable<Product> products = productRepo.findAll();

        model.put("products", products);

        return "main";
    }
}

package ru.kachalova.furniture_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kachalova.furniture_shop.domain.Category;
import ru.kachalova.furniture_shop.domain.CategoryGroup;
import ru.kachalova.furniture_shop.domain.Product;
import ru.kachalova.furniture_shop.repos.CategoryRepo;
import ru.kachalova.furniture_shop.repos.ProductRepo;
import ru.kachalova.furniture_shop.repos.UserRepo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Controller
public class ProductCatalogController {
    @Autowired
    private UserRepo clientRepo;
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/furniture")
    public String openProduct(Map<String, Object> model) {
        Stream<Product> tariffStream = StreamSupport.stream(productRepo.findAll().spliterator(), false);

        Map<Category, List<Product>> tariffByCategory = tariffStream.collect(
                Collectors.groupingBy(Product::getCategory));

        for(Map.Entry<Category, List<Product>> item : tariffByCategory.entrySet()){

            System.out.println(item.getKey().getName());
            for(Product tariff : item.getValue()){

                System.out.println(tariff.getName());
            }
            System.out.println();
        }
        model.put("product", tariffByCategory.entrySet());
        return "productList";
    }

}

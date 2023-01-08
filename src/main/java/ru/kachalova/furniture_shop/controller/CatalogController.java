package ru.kachalova.furniture_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kachalova.furniture_shop.domain.Category;
import ru.kachalova.furniture_shop.domain.CategoryGroup;
import ru.kachalova.furniture_shop.repos.CategoryRepo;
import ru.kachalova.furniture_shop.repos.UserRepo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Controller
public class CatalogController {
    @Autowired
    private UserRepo clientRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping
    public String tariff(Map<String, Object> model) {
        Stream<Category> tariffStream = StreamSupport.stream(categoryRepo.findAll().spliterator(), false);

        Map<CategoryGroup, List<Category>> tariffByCategory = tariffStream.collect(
                Collectors.groupingBy(Category::getGroup));

        for(Map.Entry<CategoryGroup, List<Category>> item : tariffByCategory.entrySet()){

            System.out.println(item.getKey().getName());
            for(Category tariff : item.getValue()){

                System.out.println(tariff.getName());
            }
            System.out.println();
        }
        model.put("tariff", tariffByCategory.entrySet());
        return "catalog";
    }

}

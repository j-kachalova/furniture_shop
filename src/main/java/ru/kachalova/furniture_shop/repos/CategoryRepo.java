package ru.kachalova.furniture_shop.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kachalova.furniture_shop.domain.Category;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
    List<Category> findByName(String name);
}

package ru.kachalova.furniture_shop.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kachalova.furniture_shop.domain.CategoryGroup;

import java.util.List;

@Repository
public interface GroupRepo extends CrudRepository<CategoryGroup, Integer> {
    List<CategoryGroup> findByName(String name);
}

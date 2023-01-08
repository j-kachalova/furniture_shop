package ru.kachalova.furniture_shop.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kachalova.furniture_shop.domain.BasketElement;

@Repository
public interface BasketElementRepo extends CrudRepository<BasketElement, Integer> {
}

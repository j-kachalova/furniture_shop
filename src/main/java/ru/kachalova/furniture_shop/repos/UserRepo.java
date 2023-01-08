package ru.kachalova.furniture_shop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kachalova.furniture_shop.domain.Human;

@Repository
public interface UserRepo extends JpaRepository<Human, Integer> {
    // Client findByLogin(String login);

    Human findByUsername(String username);
}

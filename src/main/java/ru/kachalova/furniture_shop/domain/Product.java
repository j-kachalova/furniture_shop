package ru.kachalova.furniture_shop.domain;
import lombok.Data;

import javax.persistence.*;
import java.io.File;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduct;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private Category category;
    private Integer price;
    private Integer amount;
    private String filename;
    private String description;
    public Product() {
    }

    public Product(String name, Integer price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}

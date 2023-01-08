package ru.kachalova.furniture_shop.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CategoryGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGroup;
    private String name;
    public CategoryGroup() {

    }
    public CategoryGroup(String name) {
        this.name = name;
    }



}

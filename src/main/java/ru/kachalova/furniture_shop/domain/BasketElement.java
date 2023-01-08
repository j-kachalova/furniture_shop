package ru.kachalova.furniture_shop.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BasketElement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idElement;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;
    private Integer amount;

}

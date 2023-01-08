package ru.kachalova.furniture_shop.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "human_id")
    private Human human;
    private String position;
    @ManyToOne
    @JoinColumn(name = "boss_id")
    private Employee boss;
}


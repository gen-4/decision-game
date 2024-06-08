package com.gen4.pas.survival.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;




@Entity
@Table
public class Item {
    @Id
    @SequenceGenerator(
        name = "item_sequence",
        sequenceName = "item_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "item_sequence"
    )
    private Long id;

    private String name;
    private int health;
    private int damage;

    public Item() {}

    public Item(Long id, String name, int health, int damage) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}

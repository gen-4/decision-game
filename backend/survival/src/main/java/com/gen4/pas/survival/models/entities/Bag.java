package com.gen4.pas.survival.models.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table
public class Bag {
    @Id
    @SequenceGenerator(
        name = "bag_sequence",
        sequenceName = "bag_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "bag_sequence"
    )
    private Long id;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Item> items;

    private int coins;
    private int water;
    private int bread;
    private int steak;
    private int salad;

    public Bag() {
        this.coins = 0;
        this.water = 0;
        this.bread = 0;
        this.steak = 0;
        this.salad = 0;
    }

    public Bag(Long id, List<Item> items, int coins, int water, int bread, int steak, int salad) {
        this.id = id;
        this.items = items;
        this.coins = coins;
        this.water = water;
        this.bread = bread;
        this.steak = steak;
        this.salad = salad;
    }

    public Long getId() {
        return id;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getBread() {
        return bread;
    }

    public void setBread(int bread) {
        this.bread = bread;
    }

    public int getSteak() {
        return steak;
    }

    public void setSteak(int steak) {
        this.steak = steak;
    }

    public int getSalad() {
        return salad;
    }

    public void setSalad(int salad) {
        this.salad = salad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "coins: " + coins + "\nwater: " + water + "\nbread: " + bread + "\nsteak: " + steak
            + "\nsalad: " + salad;
    }

}

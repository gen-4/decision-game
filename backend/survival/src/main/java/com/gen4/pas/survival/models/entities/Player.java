package com.gen4.pas.survival.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
        name = "player_sequence",
        sequenceName = "player_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "player_sequence"
    )
    private Long id;
    
    private String name;
    private int health;
    private int totalHealth;
    private int damage;
    private int hunger;
    private int thirst;

    @OneToOne
    private Bag bag;

    public Player() {}

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.totalHealth = 100;
        this.damage = 5;
        this.hunger = 100;
        this.thirst = 100;
    }

    public Player(Long id, String name, int health, int damage, int hunger, int thirst, int totalHealth, Bag bag) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.totalHealth = totalHealth;
        this.damage = damage;
        this.hunger = hunger;
        this.thirst = thirst;
        this.bag = bag;
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

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    @Override
    public String toString() {
        return "Player: " + name + "\nhealth: " + health + "/" + totalHealth + " (" 
        + health / totalHealth * 100 + "%)\ndamage: " + damage 
        + "\nhunger: " + hunger + "/100\nthirst: " + thirst + "/100";
    }

}

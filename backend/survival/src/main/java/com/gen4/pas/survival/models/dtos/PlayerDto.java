package com.gen4.pas.survival.models.dtos;

public class PlayerDto {
    private Long id;
    private String name;
    private int health;
    private int totalHealth;
    private int damage;
    private int hunger;
    private int thirst;
    private String description;
    private String response;

    public PlayerDto(Long id, String name, int health, int totalHealth, int damage, int hunger, int thirst,
            String description) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.totalHealth = totalHealth;
        this.damage = damage;
        this.hunger = hunger;
        this.thirst = thirst;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
}

package com.malmberg.matthew.projectgo;

/**
 * Created by Matthew on 10/10/2017.
 */

public class BioData {
    private String name;
    private Integer price;
    private String description;
    private Boolean Eat;
    private Boolean Drink;
    private Boolean Listen;
    private Boolean See;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEat() {
        return Eat;
    }

    public void setEat(Boolean eat) {
        Eat = eat;
    }

    public Boolean getDrink() {
        return Drink;
    }

    public void setDrink(Boolean drink) {
        Drink = drink;
    }

    public Boolean getListen() {
        return Listen;
    }

    public void setListen(Boolean listen) {
        Listen = listen;
    }

    public Boolean getSee() {
        return See;
    }

    public void setSee(Boolean see) {
        See = see;
    }

}

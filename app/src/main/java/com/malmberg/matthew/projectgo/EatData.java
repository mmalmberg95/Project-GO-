package com.malmberg.matthew.projectgo;

/**
 * Created by jennapfingsten on 10/15/17.
 */

public class EatData {

    private String name;
    private int price;
    private int stars;
    private String location;
    private String shortDesc;
    private String longDesc;

    public EatData(String name, int price, int stars, String location, String shortDesc, String longDesc) {
        this.name = name;
        this.price = price;
        this.stars = stars;
        this.location = location;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }
}



package com.malmberg.matthew.projectgo;

/**
 * Created by jennapfingsten on 10/15/17.
 */

public class DoData {

    private String name;
    private int price;
    private int stars;
    private String location;
    private String shortDesc;
    private String longDesc;
    private int month;
    private int day;
    private int year;

    public DoData(String name, int price, int stars, String location, String shortDesc, String longDesc, int month, int day, int year) {
        this.name = name;
        this.price = price;
        this.stars = stars;
        this.location = location;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.month = month;
        this.day = day;
        this.year = year;
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}



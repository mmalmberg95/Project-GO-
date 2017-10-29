package com.malmberg.matthew.projectgo;

import java.io.Serializable;

/**
 * Created by jennapfingsten on 10/15/17.
 */

public class DoData implements Serializable {

    private String name;
    private String price;
    private int stars;
    private String address;
    private String shortDesc;
    private String longDesc;
    private int month;
    private int day;
    private int year;
    private float latitude;
    private float longitude;
    private String imageName;

//    public DoData(String name, int price, int stars, String address, String shortDesc, String longDesc, int month, int day, int year) {
//        this.name = name;
//        this.price = price;
//        this.stars = stars;
//        this.address = address;
//        this.shortDesc = shortDesc;
//        this.longDesc = longDesc;
//        this.month = month;
//        this.day = day;
//        this.year = year;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String location) {
        this.address = location;
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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}



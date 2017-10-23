package com.malmberg.matthew.projectgo;

import java.io.Serializable;

/**
 * Created by jennapfingsten on 10/15/17.
 */

public class DrinkData implements Serializable {

    private String name;
    private int price;
    private int stars;
    private String address;
    private String shortDesc;
    private String longDesc;
    private float latitude;
    private float longitude;
    private String imageName;

//    public DrinkData(String name, int price, int stars, String address, String shortDesc, String longDesc, float latitude, float longitude) {
//        this.name = name;
//        this.price = price;
//        this.stars = stars;
//        this.address = address;
//        this.shortDesc = shortDesc;
//        this.longDesc = longDesc;
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String location) {
        this.address = address;
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




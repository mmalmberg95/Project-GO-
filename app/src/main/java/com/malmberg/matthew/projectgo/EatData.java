package com.malmberg.matthew.projectgo;

import java.io.Serializable;

/**
 * Created by jennapfingsten on 10/15/17.
 */

public class EatData implements Serializable {

    private String name;
    private String price;
    private int stars;
    private String address;
    private String shortDesc;
    private String longDesc;
    private float latitude;
    private float longitude;
    private String imageName;



    public String getName() {return name;}

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

    public void setAddress(String address) {
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



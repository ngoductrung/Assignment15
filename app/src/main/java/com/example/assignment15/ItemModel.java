package com.example.assignment15;

import android.media.Image;

public class ItemModel {
    private String name;
    private String phone;
    private String address;
    private String username;
    private String gmail;
    private Image avatar;

    public ItemModel(String name, String phone, String address, String username, String gmail, Image avatar) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.gmail = gmail;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }
}

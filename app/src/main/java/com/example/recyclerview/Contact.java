
package com.example.recyclerview;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private String lastCallDate;
    private int avatarResId;
    private boolean isFavorite;

    public Contact(String name, String phoneNumber, String lastCallDate, int avatarResId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.lastCallDate = lastCallDate;
        this.avatarResId = avatarResId;
        this.isFavorite = false;
    }

    public Contact(String name, String phoneNumber, String lastCallDate, int avatarResId, boolean isFavorite) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.lastCallDate = lastCallDate;
        this.avatarResId = avatarResId;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastCallDate() {
        return lastCallDate;
    }

    public void setLastCallDate(String lastCallDate) {
        this.lastCallDate = lastCallDate;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public void setAvatarResId(int avatarResId) {
        this.avatarResId = avatarResId;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
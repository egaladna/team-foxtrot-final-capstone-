package com.techelevator.model;

import java.util.Objects;

public class ClothingItem {
    private String type;
    private String imgUrl;
    private int userId;
    private int id;

    public ClothingItem(String type, String imgUrl, int userId, int id) {
        this.type = type;
        this.imgUrl = imgUrl;
        this.userId = userId;
        this.id = id;
    }

    public ClothingItem() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClothingItem that = (ClothingItem) o;
        return userId == that.userId && id == that.id && Objects.equals(type, that.type) && Objects.equals(imgUrl, that.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, imgUrl, userId, id);
    }
}

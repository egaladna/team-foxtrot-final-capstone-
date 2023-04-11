package com.techelevator.model;

import java.util.List;
import java.util.Objects;

public class Outfit {

    public Outfit(int outfitId, int userId) {
        this.outfitId = outfitId;
        this.userId = userId;
    }

    public Outfit() {

    }

    private int outfitId;
    private int userId;
    private List<ClothingItem> itemList;

    public List<ClothingItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<ClothingItem> itemList) {
        this.itemList = itemList;
    }

    public int getOutfitId() {
        return outfitId;
    }

    public void setOutfitId(int outfitId) {
        this.outfitId = outfitId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outfit outfit = (Outfit) o;
        return outfitId == outfit.outfitId && userId == outfit.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(outfitId, userId);
    }
}

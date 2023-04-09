package com.techelevator.dao;

import com.techelevator.model.ClothingItem;

import java.util.List;

public interface ClothesDao {

    List<ClothingItem> getClothesForUser(int userId);
    ClothingItem getClothingItemById(int itemId);
    void deleteClothingItem(int itemId);

}

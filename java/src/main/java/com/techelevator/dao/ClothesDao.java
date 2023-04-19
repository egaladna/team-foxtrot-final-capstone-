package com.techelevator.dao;

import com.techelevator.model.ClothingItem;

import java.util.List;

public interface ClothesDao {

    ClothingItem addClothingItem(ClothingItem itemToAdd);
    List<ClothingItem> getClothesForUser(int userId);
    ClothingItem getClothingItemById(int itemId);
    void deleteClothingItem(int itemId);
    List<String> listTypes();
    ClothingItem updateClothingItem(ClothingItem cloth);
}

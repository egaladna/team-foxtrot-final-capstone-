package com.techelevator.dao;



import com.techelevator.model.Outfit;

import java.util.List;

public interface OutfitDao {

    int addOutfit(int[] itemIds, int userId);
    Outfit getOutfitById(int outfitId, int userId);
    List<Outfit> getAllOutfits(int userId);
}

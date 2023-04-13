package com.techelevator.dao;

import com.techelevator.model.Outfit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcOutfitDaoTests extends BaseDaoTests{

    private JdbcOutfitDao sut;
    private static final Outfit OUTFIT_1 = new Outfit(4001,1);
    private static final Outfit OUTFIT_2 = new Outfit(4002,1);
    private static final Outfit OUTFIT_3 = new Outfit(4003,2);

    @Before
    public void setup() {
        sut = new JdbcOutfitDao(dataSource);
    }

    @Test
    public void addOutfit_returns_id() {
        int[] ids = new int[]{2001, 2002, 2004};
        Assert.assertEquals(4004, sut.addOutfit(ids, 1));
    }
    @Test
    public void getOutfitById_returns_correct_outfit(){
        Outfit outfit = sut.getOutfitById(4001,1);
        Assert.assertEquals("UserId or OutfitId does not match", OUTFIT_1,outfit);
        Assert.assertNotNull("Clothes List is missing",outfit.getItemList());
    }
    @Test
    public void getAllOutfits_returns_outfits_list(){
        List<Outfit> outfits = sut.getAllOutfits(1);
        Assert.assertTrue("Expected outfits missing",outfits.contains(OUTFIT_1) && outfits.contains(OUTFIT_2));
        Assert.assertFalse("Unexpected Outfit in list", outfits.contains(OUTFIT_3));
        Assert.assertEquals("Unexpected amount items returned", 2, outfits.size());
    }
}

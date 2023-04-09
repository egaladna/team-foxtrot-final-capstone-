package com.techelevator.dao;

import com.techelevator.model.ClothingItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcClothesDaoTests extends BaseDaoTests{
    private static final ClothingItem TEST_ITEM_1 = new ClothingItem("TOP", "https://www.rei.com/media/e1319c3d-74dc-41ba-99ce-d78ba319e9f8.jpg", 1, 2001);
    private static final ClothingItem TEST_ITEM_2 = new ClothingItem("BOTTOM", "https://images.express.com/is/image/expressfashion/0092_09192214_2919_f001?cache=on&wid=361&fmt=jpeg&qlt=75,1&resmode=sharp2&op_usm=1,1,5,0&defaultImage=Photo-Coming-Soon", 1, 2002);
    private static final ClothingItem TEST_ITEM_3 = new ClothingItem("FULL BODY", "https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/61kmUxj0PFL._UX569_.jpg", 1, 2003);
    private static final ClothingItem TEST_ITEM_4 = new ClothingItem("FOOTWEAR", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6Fa0oBMWIUf2G_qSWW7tetQf8WHnMgWQhww&usqp=CAU", 1, 2004);

    private JdbcClothesDao sut;

    @Before
    public void setup() {
        sut = new JdbcClothesDao(dataSource);
    }

    @Test
    public void getClothesForUser_gets_correct_clothes() {
        List<ClothingItem> results = sut.getClothesForUser(1);
        Assert.assertEquals("List contains incorrect number of items.",
                4, results.size());
        Assert.assertTrue("List contains incorrect items.",results.contains(TEST_ITEM_1)
                && results.contains(TEST_ITEM_2) && results.contains(TEST_ITEM_3)
                && results.contains(TEST_ITEM_4));
    }

    @Test
    public void getClothingItemById_returns_correct_item() {
       Assert.assertEquals(TEST_ITEM_1, sut.getClothingItemById(2001));
       Assert.assertEquals(TEST_ITEM_2, sut.getClothingItemById(2002));
       Assert.assertEquals(TEST_ITEM_3, sut.getClothingItemById(2003));
       Assert.assertEquals(TEST_ITEM_4, sut.getClothingItemById(2004));
    }

    @Test
    public void deleteClothingItem_deletes_correct_item() {
        Assert.assertTrue(sut.getClothesForUser(1).contains(TEST_ITEM_1));
        sut.deleteClothingItem(2001);
        Assert.assertFalse(sut.getClothesForUser(1).contains(TEST_ITEM_1));
    }


}

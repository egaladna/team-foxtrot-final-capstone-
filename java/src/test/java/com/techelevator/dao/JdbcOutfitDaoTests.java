package com.techelevator.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JdbcOutfitDaoTests extends BaseDaoTests{

    private JdbcOutfitDao sut;

    @Before
    public void setup() {
        sut = new JdbcOutfitDao(dataSource);
    }

    @Test
    public void addOutfit_returns_id() {
        int[] ids = new int[]{2001, 2002, 2004};
        Assert.assertEquals(4002, sut.addOutfit(ids, 1));
    }
}

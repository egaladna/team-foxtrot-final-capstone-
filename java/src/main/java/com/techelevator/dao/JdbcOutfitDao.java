package com.techelevator.dao;

import com.techelevator.model.ClothingItem;
import com.techelevator.model.Outfit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOutfitDao implements OutfitDao {

    private final JdbcTemplate jdbcTemplate;
    private JdbcClothesDao jdbcClothesDao;

    public JdbcOutfitDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate (dataSource);
        this.jdbcClothesDao = new JdbcClothesDao(dataSource);
    }
    @Override
    public int addOutfit(int[] itemIds, int userId) {
        String sql = "INSERT INTO outfits (user_id) " +
                "VALUES (?) RETURNING outfit_id;";
        Integer outfitId = jdbcTemplate.queryForObject(sql, Integer.class, userId);
        for (int itemId : itemIds) {
            sql = "INSERT INTO clothes_outfits (outfit_id, item_id) VALUES (?, ?);";
            jdbcTemplate.update(sql, outfitId, itemId);
        }
        return outfitId;
    }

    @Override
    public Outfit getOutfitById(int outfitId, int userId) {
        Outfit outfit = new Outfit();
        String sql ="SELECT item_id FROM clothes_outfits " +
                "JOIN outfits ON outfits.outfit_id = clothes_outfits.outfit_id " +
                "WHERE outfits.outfit_id = ? AND user_id = ?;";
        List<ClothingItem> outfitClothes = new ArrayList<>();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql,outfitId,userId);
        while(rows.next()){
            outfitClothes.add(jdbcClothesDao.getClothingItemById(rows.getInt("item_id")));
        }
        if(outfitClothes.size() == 0) {
            return null;
        }
        outfit.setOutfitId(outfitId);
        outfit.setUserId(userId);
        outfit.setItemList(outfitClothes);

        return outfit;
    }

    @Override
    public List<Outfit> getAllOutfits(int userId) {
      String sql = "SELECT outfit_id FROM outfits " +
              "WHERE user_id = ?;";
      List<Outfit> outfits = new ArrayList<>();
      SqlRowSet rows = jdbcTemplate.queryForRowSet(sql,userId);
      while(rows.next()){
          outfits.add(this.getOutfitById(rows.getInt("outfit_id"), userId));
      }
      return outfits;
    }

}

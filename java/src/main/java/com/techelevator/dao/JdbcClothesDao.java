package com.techelevator.dao;

import com.techelevator.model.ClothingItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component

public class JdbcClothesDao implements ClothesDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcClothesDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate (dataSource);
    }

    @Override
    public ClothingItem addClothingItem(ClothingItem itemToAdd) {
        String sql = "INSERT INTO clothes (type, img_url, user_id) VALUES (?, ?, ?) returning item_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, itemToAdd.getType(), itemToAdd.getImgUrl(), itemToAdd.getUserId());
        itemToAdd.setId(id);
        return itemToAdd;
    }

    @Override
    public List<ClothingItem> getClothesForUser(int userId) {
        List<ClothingItem> clothes = new ArrayList<>();
        String sql = "SELECT item_id, type, img_url, user_id FROM clothes " +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {

            ClothingItem cloth = mapRowToClothingItem(results);
            clothes.add(cloth);
        }
        return clothes;
    }

    @Override
    public ClothingItem getClothingItemById(int itemId) {
        ClothingItem cloth = new ClothingItem();
        String sql = "SELECT item_id, type, img_url, user_id FROM clothes " +
                "WHERE item_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);

        while (results.next()) {
            cloth = mapRowToClothingItem(results);
        }
        return cloth;
    }

    @Override
    public void deleteClothingItem(int itemId) {
        jdbcTemplate.update("DELETE FROM clothes_outfits where item_id = ?", itemId);
        String sql = "DELETE FROM clothes " +
                "WHERE item_id = ?;";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public List<String> listTypes() {
        List<String> types = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT type FROM item_type");
        while(results.next()) {
            types.add(results.getString("type"));
        }
        return types;
    }


    private ClothingItem mapRowToClothingItem(SqlRowSet row) {
        ClothingItem cloth = new ClothingItem();
        cloth.setId(row.getInt("item_id"));
        cloth.setImgUrl(row.getString("img_url"));
        cloth.setType(row.getString("type"));
        cloth.setUserId(row.getInt("user_id"));

        return cloth;

    }
}

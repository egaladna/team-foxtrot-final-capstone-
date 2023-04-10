package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcOutfitDao implements OutfitDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcOutfitDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate (dataSource);
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

}

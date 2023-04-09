package com.techelevator.controller;

import com.techelevator.dao.ClothesDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ClothingItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ClothesController {

    private ClothesDao clothesDao;
    private UserDao userDao;

    public ClothesController(ClothesDao clothesDao, UserDao userDao) {
        this.clothesDao = clothesDao;
        this.userDao = userDao;
    }

    @RequestMapping(path="/closet", method= RequestMethod.GET)
    public List<ClothingItem> getUserCloset(Principal principal) {
      return clothesDao.getClothesForUser(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path="/closet/{id}", method= RequestMethod.DELETE)
    public void deleteItemById(@PathVariable int id, Principal principal) {
        ClothingItem cloth = clothesDao.getClothingItemById(id);
        if (cloth != null && cloth.getUserId() != userDao.findIdByUsername(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not authorized");
        }
        clothesDao.deleteClothingItem(id);
    }
}
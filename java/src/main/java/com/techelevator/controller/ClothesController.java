package com.techelevator.controller;

import com.techelevator.dao.ClothesDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ClothingItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ClothesController {

    private ClothesDao clothesDao;
    private UserDao userDao;
    private int currentUserId;

    public ClothesController(ClothesDao clothesDao, UserDao userDao) {
        this.clothesDao = clothesDao;
        this.userDao = userDao;
    }

    @RequestMapping(path="/closet", method= RequestMethod.GET)
    public List<ClothingItem> getUserCloset(Principal principal) {
      return clothesDao.getClothesForUser(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path="closet", method=RequestMethod.POST)
    public ClothingItem addClothingItem(@RequestBody ClothingItem clothingItem, Principal principal) {
        clothingItem.setUserId(userDao.findIdByUsername(principal.getName()));
        return clothesDao.addClothingItem(clothingItem);
    }

    @RequestMapping(path="closet/{id}", method=RequestMethod.PUT)
    public ClothingItem updateItemById(@Valid @RequestBody ClothingItem clothingItem, @PathVariable("id") int id) {
        if (clothesDao.getClothingItemById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Clothing item not found.");
        }
        return clothesDao.updateClothingItem(clothingItem);
    }

    @RequestMapping(path="/closet/{id}", method= RequestMethod.DELETE)
    public void deleteItemById(@PathVariable int id, Principal principal) {
        ClothingItem cloth = clothesDao.getClothingItemById(id);
        if (cloth != null && cloth.getUserId() != userDao.findIdByUsername(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not authorized");
        }
        clothesDao.deleteClothingItem(id);
    }


    @RequestMapping(path = "/types", method = RequestMethod.GET)
    public List<String> listTypes() {
        return clothesDao.listTypes();
    }
}

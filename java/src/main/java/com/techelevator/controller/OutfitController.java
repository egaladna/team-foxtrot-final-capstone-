package com.techelevator.controller;

import com.techelevator.dao.OutfitDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ClothingItem;
import com.techelevator.model.Outfit;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class OutfitController {

    private OutfitDao outfitDao;
    private UserDao userDao;

    public OutfitController(OutfitDao outfitDao, UserDao userDao) {
        this.userDao = userDao;
        this.outfitDao = outfitDao;
    }

    @RequestMapping(path = "/outfits", method = RequestMethod.POST)
    public int addAnOutfit(@RequestBody ClothingItem[] clothes, Principal principal){
        int[] itemIds = new int[clothes.length];
        for (int i =0; i < itemIds.length; i++){
            itemIds[i] = clothes[i].getId();
            if(clothes[i].getUserId() != userDao.findIdByUsername(principal.getName())) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Can't add clothes not in your closet.");
            }
        }
       return outfitDao.addOutfit(itemIds, userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path ="/outfits", method = RequestMethod.GET)
    public List<Outfit> getAllOutfitsForUser(Principal principal){
        return outfitDao.getAllOutfits(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/outfits/{id}", method = RequestMethod.GET)
    public Outfit getOutfitById(@PathVariable int id, Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());
        Outfit outfit = outfitDao.getOutfitById(id, userId);
        if (outfit != null && outfit.getUserId() != userId){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Can't see outfits that aren't yours");
        }
        return outfit;
    }

}

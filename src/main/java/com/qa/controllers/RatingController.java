package com.qa.controllers;


import com.qa.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.models.Rating;
import org.springframework.web.bind.annotation.PutMapping;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.List;

@CrossOrigin
@RestController
public class RatingController {

    @Autowired
    @ElementCollection(fetch= FetchType.LAZY)
    private RatingRepository repository;

    @RequestMapping(value = "ratings/{id}", method = RequestMethod.GET)
    public Rating getRatingsById(@PathVariable String id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "add/rating/{id}/{clan}",method = RequestMethod.PUT)
    public Rating updateRating(@PathVariable String id, @PathVariable String clan, @RequestBody Rating rating){
        Rating card = repository.findOne(id);

        float tmpRating;

        switch (clan){
            case "crab":
                tmpRating = card.getRatingcrab();
                // newrating = ((currentvotes * currentrating) + newvote)/currentvotes + 1
                card.setRatingcrab(((card.getTotalvotescrab() * card.getRatingcrab()) +tmpRating)/card.getTotalvotescrab() + 1);
                card.setTotalvotescrab(card.getTotalvotescrab() + 1);
                repository.saveAndFlush(card);
                break;
            case "crane":
                tmpRating = card.getRatingcrane();
                card.setRatingcrane(((card.getTotalvotescrane() * card.getRatingcrane()) +tmpRating)/card.getTotalvotescrane() + 1);
                card.setTotalvotescrane(card.getTotalvotescrane() + 1);
                repository.saveAndFlush(card);
                break;
            case "dragon":
                tmpRating = card.getRatingdragon();
                card.setRatingdragon(((card.getTotalvotesdragon() * card.getRatingdragon()) +tmpRating)/card.getTotalvotesdragon() + 1);
                card.setTotalvotesdragon(card.getTotalvotesdragon() + 1);
                repository.saveAndFlush(card);
                break;
            case "lion":
                tmpRating = card.getRatinglion();
                card.setRatinglion(((card.getTotalvoteslion() * card.getRatinglion()) +tmpRating)/card.getTotalvoteslion() + 1);
                card.setTotalvoteslion(card.getTotalvoteslion() + 1);
                repository.saveAndFlush(card);
                break;
            case "phoenix":
                tmpRating = card.getRatingphoenix();
                card.setRatingphoenix(((card.getTotalvotesphoenix() * card.getRatingphoenix()) +tmpRating)/card.getTotalvotesphoenix() + 1);
                card.setTotalvotesphoenix(card.getTotalvotesphoenix() + 1);
                repository.saveAndFlush(card);
                break;
            case "scorpion":
                tmpRating = card.getRatingscorpion();
                card.setRatingscorpion(((card.getTotalvotesscorpion() * card.getRatingscorpion()) +tmpRating)/card.getTotalvotesscorpion() + 1);
                card.setTotalvotesscorpion(card.getTotalvotesscorpion() + 1);
                repository.saveAndFlush(card);
                break;
            case "unicorn":
                tmpRating = card.getRatingunicorn();
                card.setRatingunicorn(((card.getTotalvotesunicorn() * card.getRatingunicorn()) +tmpRating)/card.getTotalvotesunicorn() + 1);
                card.setTotalvotesunicorn(card.getTotalvotesunicorn() + 1);
                repository.saveAndFlush(card);
                break;
            default:
                System.out.println("beep boop");
        }

        return card;
    }

}
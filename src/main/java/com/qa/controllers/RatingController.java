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

    @RequestMapping(value = "add/ratings/crab/{id}",method = RequestMethod.PUT)
    public Rating addRatingVSCrab(@PathVariable String id, @RequestBody Rating rating){
        Rating card = repository.findOne(id);

        System.out.println("beep boop");

        if(card.getTotalvotescrab() == 0 || card.getRatingcrab() == 0){
            card.setRatingcrab(rating.getRatingcrab());
            System.out.println("beep boop");
        }
        else{
            card.setRatingcrab(((card.getTotalvotescrab() * card.getRatingcrab()) + rating.getRatingcrab())/(card.getTotalvotescrab() + 1));
            System.out.println("card votes crab: " + card.getTotalvotescrab());
            System.out.println("rating rating crab : " + card.getRatingcrab());
            System.out.println("tmp variable : " + rating.getRatingcrab());

        }

        card.setTotalvotescrab(card.getTotalvotescrab() + 1);
        repository.saveAndFlush(card);
        return card;
    }

    @RequestMapping(value = "remove/ratings/crab/{id}",method = RequestMethod.PUT)
    public Rating removeRatingVSCrab(@PathVariable String id, @RequestBody Rating rating){
        Rating card = repository.findOne(id);

        System.out.println("beep boop");

        if(card.getTotalvotescrab() == 0){

        }
        else if(card.getRatingcrab() - rating.getRatingcrab() <0){
            card.setRatingcrab(0);
            card.setTotalvotescrab(card.getTotalvotescrab() - 1);
        }
        else{
            card.setRatingcrab(((card.getTotalvotescrab() * card.getRatingcrab()) - rating.getRatingcrab())/(card.getTotalvotescrab() - 1));
            card.setTotalvotescrab(card.getTotalvotescrab() - 1);
        }

        repository.saveAndFlush(card);
        return card;
    }



}
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

    @RequestMapping(value = "ratings/crab/{id}",method = RequestMethod.PUT)
    public Rating updateRatingVSCrab(@PathVariable String id, @RequestBody Rating rating){
        Rating card = repository.findOne(id);

        float tmpRating = rating.getRatingcrab();
        //card.setRatingcrab(rating.getRatingcrab());

        if(rating.getTotalvotescrab() == 0 || rating.getRatingcrab() == 0){
            card.setRatingcrab(rating.getRatingcrab());
        }
        else{
            card.setRatingcrab(((rating.getTotalvotescrab() * card.getRatingcrab()) +tmpRating)/(rating.getTotalvotescrab() + 1));
        }

        card.setTotalvotescrab(card.getTotalvotescrab() + 1);
        repository.saveAndFlush(card);
        return card;
    }



}
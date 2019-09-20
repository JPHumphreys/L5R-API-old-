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

    @RequestMapping(value = "add/ratings/{clan}/{id}",method = RequestMethod.PUT)
    public Rating addRatingVSCrab(@PathVariable String clan, @PathVariable String id,@RequestBody Rating rating){
        Rating card = repository.findOne(id);

        switch (clan){
            case "crab":
                if(card.getTotalvotescrab() == 0 || card.getRatingcrab() == 0){
                    card.setRatingcrab(rating.getRatingcrab());
                }
                else{
                    card.setRatingcrab(((card.getTotalvotescrab() * card.getRatingcrab()) + rating.getRatingcrab())/(card.getTotalvotescrab() + 1));
                }
                card.setTotalvotescrab(card.getTotalvotescrab() + 1);
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "crane":
                if(card.getTotalvotescrane() == 0 || card.getRatingcrane() == 0){
                    card.setRatingcrane(rating.getRatingcrane());
                }
                else{
                    card.setRatingcrane(((card.getTotalvotescrane() * card.getRatingcrane()) + rating.getRatingcrane())/(card.getTotalvotescrane() + 1));
                }
                card.setTotalvotescrane(card.getTotalvotescrane() + 1);
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "dragon":
                if(card.getTotalvotesdragon() == 0 || card.getRatingdragon() == 0){
                    card.setRatingdragon(rating.getRatingdragon());
                }
                else{
                    card.setRatingdragon(((card.getTotalvotesdragon() * card.getRatingdragon()) + rating.getRatingdragon())/(card.getTotalvotesdragon() + 1));
                }
                card.setTotalvotesdragon(card.getTotalvotesdragon() + 1);
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "lion":
                if(card.getTotalvoteslion() == 0 || card.getRatinglion() == 0){
                    card.setRatinglion(rating.getRatinglion());
                }
                else{
                    card.setRatinglion(((card.getTotalvoteslion() * card.getRatinglion()) + rating.getRatinglion())/(card.getTotalvoteslion() + 1));
                }
                card.setTotalvoteslion(card.getTotalvoteslion() + 1);
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "phoenix":
                if(card.getTotalvotesphoenix() == 0 || card.getRatingphoenix() == 0){
                    card.setRatingphoenix(rating.getRatingphoenix());
                }
                else{
                    card.setRatingphoenix(((card.getTotalvotesphoenix() * card.getRatingphoenix()) + rating.getRatingphoenix())/(card.getTotalvotesphoenix() + 1));
                }
                card.setTotalvotesphoenix(card.getTotalvotesphoenix() + 1);
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "scorpion":
                if(card.getTotalvotesscorpion() == 0 || card.getRatingscorpion() == 0){
                    card.setRatingscorpion(rating.getRatingscorpion());
                }
                else{
                    card.setRatingscorpion(((card.getTotalvotesscorpion() * card.getRatingscorpion()) + rating.getRatingscorpion())/(card.getTotalvotesscorpion() + 1));
                }
                card.setTotalvotesscorpion(card.getTotalvotesscorpion() + 1);
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "unicorn":
                if(card.getTotalvotesunicorn() == 0 || card.getRatingunicorn() == 0){
                    card.setRatingunicorn(rating.getRatingunicorn());
                }
                else{
                    card.setRatingunicorn(((card.getTotalvotesunicorn() * card.getRatingunicorn()) + rating.getRatingunicorn())/(card.getTotalvotesunicorn() + 1));
                }
                card.setTotalvotesunicorn(card.getTotalvotesunicorn() + 1);
                card.setOverallrating(returnNewOverallRating(card));
                break;
        }
        repository.saveAndFlush(card);
        return card;
    }

    @RequestMapping(value = "remove/ratings/{clan}/{id}",method = RequestMethod.PUT)
    public Rating removeRatingVSCrab(@PathVariable String clan, @PathVariable String id, @RequestBody Rating rating){
        Rating card = repository.findOne(id);

        switch (clan){
            case "crab":
                if(card.getTotalvotescrab() <=1){
                    card.setRatingcrab(0);
                    card.setTotalvotescrab(0);
                }
                else{
                    card.setRatingcrab(((card.getTotalvotescrab() * card.getRatingcrab()) - rating.getRatingcrab())/(card.getTotalvotescrab() - 1));
                    card.setTotalvotescrab(card.getTotalvotescrab() - 1);
                }
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "crane":
                if(card.getTotalvotescrane() <=1){
                    card.setRatingcrane(0);
                    card.setTotalvotescrane(0);
                }
                else{
                    card.setRatingcrane(((card.getTotalvotescrane() * card.getRatingcrane()) - rating.getRatingcrane())/(card.getTotalvotescrane() - 1));
                    card.setTotalvotescrane(card.getTotalvotescrane() - 1);
                }
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "dragon":
                if(card.getTotalvotesdragon() <=1){
                    card.setRatingdragon(0);
                    card.setTotalvotesdragon(0);
                }
                else{
                    card.setRatingdragon(((card.getTotalvotesdragon() * card.getRatingdragon()) - rating.getRatingdragon())/(card.getTotalvotesdragon() - 1));
                    card.setTotalvotesdragon(card.getTotalvotesdragon() - 1);
                }
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "lion":
                if(card.getTotalvoteslion() <=1){
                    card.setRatinglion(0);
                    card.setTotalvoteslion(0);
                }
                else{
                    card.setRatinglion(((card.getTotalvoteslion() * card.getRatinglion()) - rating.getRatinglion())/(card.getTotalvoteslion() - 1));
                    card.setTotalvoteslion(card.getTotalvoteslion() - 1);
                }
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "phoenix":
                if(card.getTotalvotesphoenix() <=1){
                    card.setRatingphoenix(0);
                    card.setTotalvotesphoenix(0);
                }
                else{
                    card.setRatingphoenix(((card.getTotalvotesphoenix() * card.getRatingphoenix()) - rating.getRatingphoenix())/(card.getTotalvotesphoenix() - 1));
                    card.setTotalvotesphoenix(card.getTotalvotesphoenix() - 1);
                }
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "scorpion":
                if(card.getTotalvotesscorpion() <=1){
                    card.setRatingscorpion(0);
                    card.setTotalvotesscorpion(0);
                }
                else{
                    card.setRatingscorpion(((card.getTotalvotesscorpion() * card.getRatingscorpion()) - rating.getRatingscorpion())/(card.getTotalvotesscorpion() - 1));
                    card.setTotalvotesscorpion(card.getTotalvotesscorpion() - 1);
                }
                card.setOverallrating(returnNewOverallRating(card));
                break;
            case "unicorn":
                if(card.getTotalvotesunicorn() <=1){
                    card.setRatingunicorn(0);
                    card.setTotalvotesunicorn(0);
                }
                else{
                    card.setRatingunicorn(((card.getTotalvotesunicorn() * card.getRatingunicorn()) - rating.getRatingunicorn())/(card.getTotalvotesunicorn() - 1));
                    card.setTotalvotesunicorn(card.getTotalvotesunicorn() - 1);
                }
                card.setOverallrating(returnNewOverallRating(card));
                break;
        }
        repository.saveAndFlush(card);
        return card;
    }

    public float returnNewOverallRating(Rating obj){

    int totalVotes = obj.getTotalvotescrab() +
            obj.getTotalvotescrane() +
            obj.getTotalvotesdragon() +
            obj.getTotalvoteslion() +
            obj.getTotalvotesphoenix() +
            obj.getTotalvotesscorpion() +
            obj.getTotalvotesunicorn();

    float totalRatings = obj.getRatingcrab() +
            obj.getRatingcrane() +
            obj.getRatingdragon() +
            obj.getRatinglion() +
            obj.getRatingphoenix() +
            obj.getRatingscorpion() +
            obj.getRatingunicorn();

    return (totalRatings / totalVotes);

    }




}
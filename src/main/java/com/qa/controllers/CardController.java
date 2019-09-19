package com.qa.controllers;


import com.qa.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.models.Card;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class CardController {

    @Autowired
    @ElementCollection(fetch= FetchType.LAZY)
    private CardRepository repository;

    @RequestMapping(value = "cards", method = RequestMethod.GET)
    public List<Card> listAllCards(){
        return repository.findAll();
    }

    @RequestMapping(value = "cards/{id}", method = RequestMethod.GET)
    public Card getCard(@PathVariable String id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "cards/clans/{clan}", method = RequestMethod.GET)
    public List<Card> getCardByClan(@PathVariable String clan){
        return repository.findAllByClan(clan);
    }

    @RequestMapping(value = "cards/{clan}/{side}", method = RequestMethod.GET)
    public List<Card> getCardByClanAndSide(@PathVariable String clan,@PathVariable String side){
        return repository.findAllByClanAndSide(clan,side);
    }

    @RequestMapping(value = "cards/{id}", method = RequestMethod.DELETE)
    public Card deleteCard(@PathVariable String id){
        Card existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    @RequestMapping(value = "cards/{id}",method = RequestMethod.PUT)
    public Card updateCard(@PathVariable String id){
        Card existing = repository.findOne(id);
        return repository.saveAndFlush(existing);
    }



}

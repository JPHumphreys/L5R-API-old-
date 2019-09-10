package com.qa.controllers;


import com.qa.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.models.Card;
import java.util.List;

@CrossOrigin
@RestController
public class CardController {

    @Autowired
    private CardRepository repository;

    @RequestMapping(value = "cards", method = RequestMethod.GET)
    public List<Card> listAllCards(){
        return repository.findAll();
    }

    @RequestMapping(value = "cards", method = RequestMethod.POST)
    public Card addCard(@RequestBody Card card){
        return repository.saveAndFlush(card);
    }

    @RequestMapping(value = "cards/{id}", method = RequestMethod.DELETE)
    public  Card deleteNote(@PathVariable Long id){
        Card existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }



}

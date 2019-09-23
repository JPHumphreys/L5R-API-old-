package com.qa.controllers;


import com.qa.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.models.Deck;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.List;

@CrossOrigin
@RestController
public class DeckController {

    @Autowired
    @ElementCollection(fetch= FetchType.LAZY)
    private DeckRepository repository;

    @RequestMapping(value = "get/deck/{userid}/{deckname}", method = RequestMethod.GET)
    public List<Deck> getDeckByUsernameAndDeckname(@PathVariable String userid,@PathVariable String deckname){
        return repository.findAllByUseridAndDeckname(userid,deckname);
    }

    @RequestMapping(value = "update/deck/{userid}/{deckname}", method = RequestMethod.PUT)
    public List<Deck> updateDeckByUsernameAndDeckname(@PathVariable String userid, @PathVariable String deckname, @RequestBody Deck deck){

        List<Deck> cards = repository.findAllByUseridAndDeckname(userid,deckname);
        String newDeckname = deck.getDeckname();

        for(int i = 0; i < cards.size(); i++){
            cards.get(i).setDeckname(newDeckname);
            repository.saveAndFlush(cards.get(i));
        }

        return cards;
    }

    @RequestMapping(value = "delete/deck/{userid}/{deckname}", method = RequestMethod.DELETE)
    public List<Deck> deleteDeckByUsernameAndDeckname(@PathVariable String userid, @PathVariable String deckname){

        List<Deck> cards = repository.findAllByUseridAndDeckname(userid,deckname);
        repository.delete(cards);
        return cards;
    }

    @RequestMapping(value = "post/deck/",method = RequestMethod.POST)
    public Deck createDeckByUserid(@RequestBody Deck deck){

          return repository.saveAndFlush(deck);
    }




}
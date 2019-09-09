package com.qa.controllers;


import com.qa.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.qa.models.Card;
import java.util.List;

@CrossOrigin
@RestController
public class CardController {

    @Autowired
    private CardRepository repository;

    @RequestMapping(value = "notes", method = RequestMethod.GET)
    public List<Card> listAllCards(){
        return repository.findAll();
    }
}

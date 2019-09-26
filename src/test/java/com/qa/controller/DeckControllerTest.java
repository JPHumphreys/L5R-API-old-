package com.qa.controller;

import com.qa.controllers.DeckController;
import com.qa.models.Deck;
import com.qa.repository.DeckRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeckControllerTest {

    @InjectMocks//below is class were testing
    private DeckController deckController;

    @Mock
    private DeckRepository repository;

    @Test
    public void testDeckGetRequest(){
        List<Deck> decklist = new ArrayList<>();
        Deck deck = new Deck();

        deck.setUserid("david");
        deck.setDeckname("womble");
        deck.setCardid("kaiu-envoy");
        deck.setQuantity(3);

        decklist.add(deck);

    when(repository.findAllByUseridAndDeckname("david","womble")).thenReturn(decklist);
    assertEquals(deckController.getDeckByUsernameAndDeckname("david","womble").get(0).getUserid(), "david");
        assertEquals(deckController.getDeckByUsernameAndDeckname("david","womble").get(0).getDeckname(), "womble");


    }

    @Test
    public void testDeckGetWithConstructor(){

        List<Deck> decklist = new ArrayList<>();
        Deck deckConstructor = new Deck("test", "deckname", "hida-kisada", 3);

        decklist.add(deckConstructor);

        when(repository.findAllByUseridAndDeckname("test","deckname")).thenReturn(decklist);
        assertEquals(deckController.getDeckByUsernameAndDeckname("test","deckname").get(0).getUserid(), "test");
        assertEquals(deckController.getDeckByUsernameAndDeckname("test","deckname").get(0).getDeckname(), "deckname");
    }


}
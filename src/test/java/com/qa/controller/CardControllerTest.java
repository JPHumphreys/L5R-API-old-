package com.qa.controller;

import com.qa.controllers.CardController;
import com.qa.models.Card;
import com.qa.repository.CardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardControllerTest {

    @InjectMocks//below is class were testing
    private CardController cardController;

    @Mock
    private CardRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAddCard(){
        Card card = new Card();
        card.setClan("Crab");
        card.setDeckType("Stronghold");
        card.setName("Shiro Nishiyama");

        when(repository.saveAndFlush(card)).thenReturn(card);
        cardController.addCard(card);
    }

    @Test//getOne
    public void testGetCard(){
        Card card = new Card();
        card.setName("Shiro Nishiyama");
        card.setClan("Crab");
        card.setDeckType("Stronghold");

        when(repository.findOne(1l)).thenReturn(card);
        cardController.getCard(1l);

    }

    @Test//getAll
    public void testGetAllCards(){
        List<Card> cardList = new ArrayList<>();
        Card card = new Card();
        card.setClan("Crab");
        card.setDeckType("Stronghold");
        card.setName("Shiro Nishiyama");
        cardList.add(card);

        //mocking a database
        //when i call X - return me this istead
        when(repository.findAll()).thenReturn(cardList);
        cardController.listAllCards();//.get(0).getName() - wrap in a assertEquals

        //assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/cards", List.class)).contains("beep boop");
    }
}

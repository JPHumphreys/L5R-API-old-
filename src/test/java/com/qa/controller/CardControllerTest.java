package com.qa.controller;

import com.qa.controllers.CardController;
import com.qa.models.Card;
import com.qa.repository.CardRepository;
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
public class CardControllerTest {

    @InjectMocks//below is class were testing
    private CardController cardController;

    @Mock
    private CardRepository repository;

    @Test
    public void testGetCardByClanAndSide() {  //every test should be public void

            List<Card> cards = new ArrayList<>();

            Card card = new Card();

            card.setId("temp-char-");
            card.setClan("crab");
            card.setCost(2);
            card.setDecklimit(3);
            card.setElement("fire");
            card.setFate(2);
            card.setGlory(2);
            card.setHonor(0);
            card.setImglocation("https");
            card.setInfluencepool(1);
            card.setInfluencecost(1);
            card.setIsrestricted("false");
            card.setMilitary(3);
            card.setMilitarybonus("+1");
            card.setName("temp char");
            card.setPolitical(2);
            card.setPoliticalbonus("+0");
            card.setRolerestriction("false");
            card.setSide("conflict");
            card.setStrength(1);
            card.setStrengthbonus("+0");
            card.setText("temp text");
            card.setTypeof("test");
            card.setUnicity("false");

            cards.add(card);

            when(repository.findAllByClanAndSide("crab","conflict")).thenReturn(cards);

            assertEquals(cardController.getCardByClanAndSide("crab","conflict").get(0).getSide(), "conflict");

    }

    @Test
    public void testGetCardByClan(){
            List<Card> cards = new ArrayList<>();

            Card card = new Card();

            card.setId("temp-char-");
            card.setClan("crab");
            card.setCost(2);
            card.setDecklimit(3);
            card.setElement("fire");
            card.setFate(2);
            card.setGlory(2);
            card.setHonor(0);
            card.setImglocation("https");
            card.setInfluencepool(1);
            card.setInfluencecost(1);
            card.setIsrestricted("false");
            card.setMilitary(3);
            card.setMilitarybonus("+1");
            card.setName("temp char");
            card.setPolitical(2);
            card.setPoliticalbonus("+0");
            card.setRolerestriction("false");
            card.setSide("conflict");
            card.setStrength(1);
            card.setStrengthbonus("+0");
            card.setText("temp text");
            card.setTypeof("test");
            card.setUnicity("false");

            cards.add(card);

            when(repository.findAllByClan("crab")).thenReturn(cards);

            assertEquals(cardController.getCardByClan("crab").get(0).getSide(),"conflict");
    }
}

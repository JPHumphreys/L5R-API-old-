package com.qa.repository;

import com.qa.models.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Long>{

    //List<Rating> findOneByClanAndSide(String clan, String side);

    List<Deck> findAllByUseridAndDeckname(String userid, String deckname);

}
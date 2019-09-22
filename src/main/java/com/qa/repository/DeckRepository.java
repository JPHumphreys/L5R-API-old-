package com.qa.repository;

import com.qa.models.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, String>{

    //List<Rating> findOneByClanAndSide(String clan, String side);

    //List<Card> findAllByClanAndSide(String clan, String side);

}
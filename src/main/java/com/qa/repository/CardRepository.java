package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Card;

public interface CardRepository extends JpaRepository<Card, String>{

    public List<Card> findAllByClan(String clan);

}

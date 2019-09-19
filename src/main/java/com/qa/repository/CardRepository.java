package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Card;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, String>{

    List<Card> findAllByClan(String clan);

}

package com.qa.repository;

import com.qa.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String>{

    //List<Rating> findOneByClanAndSide(String clan, String side);

    List<Rating> findAllByClan(String clan);

}

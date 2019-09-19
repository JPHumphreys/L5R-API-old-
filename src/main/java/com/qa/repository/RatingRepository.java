package com.qa.repository;

import com.qa.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Card;
import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String>{

    //List<Rating> findOneByIdAndRatingcrab(String id, String ratingcrab);

    //List<Card> findAllByClanAndSide(String clan, String side);

}

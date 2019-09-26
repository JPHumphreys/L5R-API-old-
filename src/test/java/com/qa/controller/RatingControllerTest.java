package com.qa.controller;

import com.qa.controllers.RatingController;
import com.qa.models.Rating;
import com.qa.repository.RatingRepository;
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
public class RatingControllerTest {

    @InjectMocks//below is class were testing
    private RatingController ratingController;

    @Mock
    private RatingRepository repository;

    @Test
    public void testGetRatingByClan(){

        List<Rating> ratingList = new ArrayList<>();
        Rating rating = new Rating();

        rating.setId("hida-kisada");
        rating.setClan("crab");
        rating.setOverallrating(3);
        rating.setRatingcrab(4);
        rating.setRatingcrane(3);
        rating.setRatingdragon(3);
        rating.setRatinglion(8);
        rating.setRatingphoenix(5);
        rating.setRatingscorpion(2);
        rating.setRatingunicorn(5);
        rating.setTotalvotescrab(1);
        rating.setTotalvotescrane(4);
        rating.setTotalvotesdragon(3);
        rating.setTotalvoteslion(6);
        rating.setTotalvotesphoenix(4);
        rating.setTotalvotesscorpion(4);
        rating.setTotalvotesunicorn(3);

        ratingList.add(rating);

        when(repository.findAllByClan("crab")).thenReturn(ratingList);

        assertEquals(ratingController.getRatingByClan("crab").get(0).getId(),"hida-kisada");
    }

    @Test
    public void testPutRating(){//this does for both puts (add/remove voting)

        Rating rating = new Rating();

        rating.setId("test");
        rating.setClan("crab");
        rating.setOverallrating(3);
        rating.setRatingcrab(4);
        rating.setRatingcrane(3);
        rating.setRatingdragon(3);
        rating.setRatinglion(8);
        rating.setRatingphoenix(5);
        rating.setRatingscorpion(2);
        rating.setRatingunicorn(5);
        rating.setTotalvotescrab(1);
        rating.setTotalvotescrane(4);
        rating.setTotalvotesdragon(3);
        rating.setTotalvoteslion(6);
        rating.setTotalvotesphoenix(4);
        rating.setTotalvotesscorpion(4);
        rating.setTotalvotesunicorn(3);

        when(repository.findOne("test")).thenReturn(rating);

        assertEquals(ratingController.addRatingVSClan("crab","test",rating).getTotalvoteslion(),6);
    }

}

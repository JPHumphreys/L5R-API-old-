package com.qa.repository;

import com.qa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String>{

    //List<Rating> findOneByClanAndSide(String clan, String side);

    //List<Card> findAllByClanAndSide(String clan, String side);

}
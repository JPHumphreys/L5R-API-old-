package com.qa.controllers;


import com.qa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.models.User;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.List;

@CrossOrigin
@RestController

public class UserController {

    @Autowired
    @ElementCollection(fetch = FetchType.LAZY)
    private UserRepository repository;

    @RequestMapping(value = "ratings/{userid}", method = RequestMethod.GET)
    public User getUserId(@PathVariable String userid){
        return repository.findOne(userid);
    }

}
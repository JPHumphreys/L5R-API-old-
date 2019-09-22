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

    @RequestMapping(value = "getuser/{userid}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String userid){
        return repository.findOne(userid);
    }

    @RequestMapping(value = "deleteuser/{userid}", method = RequestMethod.DELETE)
    public User deleteUserById(@PathVariable String userid){
        User user = repository.findOne(userid);
        repository.delete(user);
        return user;
    }

    @RequestMapping(value = "adduser/", method = RequestMethod.POST)
    public User addUserById(@RequestBody User user){
        return repository.saveAndFlush(user);

    }

}
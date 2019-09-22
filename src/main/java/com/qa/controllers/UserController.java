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


    @RequestMapping(value = "get/user/{userid}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String userid){
        return repository.findOne(userid);
    }

    @RequestMapping(value = "delete/user/{userid}", method = RequestMethod.DELETE)
    public User deleteUserById(@PathVariable String userid){
        User user = repository.findOne(userid);
        repository.delete(user);
        return user;
    }

    @RequestMapping(value = "add/user/", method = RequestMethod.POST)
    public User addUserById(@RequestBody User user){
        return repository.saveAndFlush(user);

    }

    @RequestMapping(value = "update/user/{userid}",method = RequestMethod.PUT)
    public User updateUserById(@PathVariable String userid, @RequestBody User user){
        User currentUser = repository.findOne(userid);
        currentUser.setPassword(user.getPassword());
        repository.saveAndFlush(currentUser);
        return currentUser;
    }

}
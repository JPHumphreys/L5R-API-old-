package com.qa.controller;

import com.qa.controllers.UserController;
import com.qa.models.User;
import com.qa.repository.UserRepository;
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
public class UserControllerTest {

    @InjectMocks//below is class were testing
    private UserController userController;

    @Mock
    private UserRepository repository;

    @Test
    public void testGetUserRequest(){
        User user = new User();

        user.setUserid("empty");
        user.setPassword("pass");

        when(repository.findOne("empty")).thenReturn(user);
        assertEquals(user.getUserid(),"empty");
        assertEquals(user.getPassword(),"pass");

    }

    @Test
    public void testGetUserConstructorRequest(){
        User userConstructor = new User("const", "password");

        when(repository.findOne("const")).thenReturn(userConstructor);
        assertEquals(userConstructor.getUserid(),"const");
        assertEquals(userConstructor.getPassword(),"password");

    }

    @Test
    public void testPostUserRequest(){

        User user = new User("wer","pass");

        when(repository.saveAndFlush(user)).thenReturn(user);
        assertEquals(userController.addUserById(user).getPassword(),"pass");

    }

    @Test
    public void testPutUserRequest(){

    }

    @Test
    public void testDeleteUserRequest(){

    }

}
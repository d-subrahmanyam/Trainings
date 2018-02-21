package com.subbu.estore.services.impl;

import com.subbu.estore.clients.UserServiceClient;
import com.subbu.estore.dtos.User;
import com.subbu.estore.exceptions.UserNotFoundException;
import com.subbu.estore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by subbu on 19/02/18.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public User add(User user) {
        ResponseEntity<User> userResponseEntity = null;
        boolean userNotFound = false;
        User _user = null;
        try{
            userResponseEntity = userServiceClient.findByUsername(user.getUsername());
        } catch (UserNotFoundException userNotFoundException) {
            userNotFound = true;
        }

        if(userNotFound) {
            _user = userServiceClient.save(user);
        } else {
            _user = userResponseEntity.getBody();
        }
        return _user;
    }

    @Override
    public void update(User user) {
        userServiceClient.save(user);
    }

    @Override
    public void remove(long id) {
        //userServiceClient.delete(id);
    }

    @Override
    public User get(long id) {
        return null; //userServiceClient.getOne(id);
    }

    @Override
    public User findByUsername(String username) throws UserNotFoundException {
        return userServiceClient.findByUsername(username).getBody();
    }

    @Override
    public User findByGuid(String guid) throws UserNotFoundException {
        return userServiceClient.findByGuid(guid).getBody();
    }

    @Override
    public Collection<User> findByFirstname(String firstname) {
        return userServiceClient.findByFirstname(firstname).getContent();
    }

    @Override
    public Collection<User> findByLastname(String lastname) {
        return userServiceClient.findByLastname(lastname).getContent();
    }

    @Override
    public Collection<User> all() {
        return userServiceClient.findAll().getContent();
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userServiceClient.findByUsername(username).getBody();
        if(!user.getPassword().equalsIgnoreCase(password)) user = null;
        return user;
    }
}

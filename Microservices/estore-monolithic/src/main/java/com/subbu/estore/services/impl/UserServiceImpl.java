package com.subbu.estore.services.impl;

import com.subbu.estore.entities.User;
import com.subbu.estore.repos.UserRepo;
import com.subbu.estore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User add(User user) {
        User _user = null;
        if(userRepo.findByUsername(user.getUsername()) != null) {
            return _user;
        } else {
            _user = userRepo.save(user);
        }
        return _user;
    }

    @Override
    public void update(User user) {
        userRepo.save(user);
    }

    @Override
    public void remove(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User get(long id) {
        return userRepo.getOne(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getByFirstname(String firstname) {
        return userRepo.findByFirstname(firstname);
    }

    @Override
    public List<User> getByLastname(String lastname) {
        return userRepo.findByLastname(lastname);
    }

    @Override
    public List<User> all() {
        return userRepo.findAll();
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepo.findByUsername(username);
        if(!user.getPassword().equalsIgnoreCase(password)) user = null;
        return user;
    }
}

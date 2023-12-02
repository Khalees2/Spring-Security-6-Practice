package com.practice.springsecurity.service;

import com.practice.springsecurity.dao.UserDao;
import com.practice.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
//@Service //Marking it as @Component for the development purpose
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public User getUserById(String userId){
        return this.userDao.getUserByUserId(userId);
    }

}

package com.practice.springsecurity.dao;

import com.practice.springsecurity.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
//@Entity //Marking it as @Component for the development purpose
public class UserDao {

    //Below initialization is only for development purpose
    List<User> userList = new ArrayList<>();
    public UserDao(){
        ArrayList<String> userRoles = new ArrayList<>();
        userRoles.add("user");
        this.userList.add(new User("user","1234",userRoles));
        ArrayList<String> adminRoles = new ArrayList<>();
        adminRoles.add("admin");
        this.userList.add(new User("admin","1234",adminRoles));
    }

    //Below technique of getting user is only for the development purpose.
    //We should be getting user details from DB and match the hashed value of password than the plain text.
    public User getUserByUserId(String userId){
        User user = null;
        for(User userInList: userList){
            if(userInList.getUserId().equals(userId)){
                user = userInList;
            }
        }
        return user;
    }
}

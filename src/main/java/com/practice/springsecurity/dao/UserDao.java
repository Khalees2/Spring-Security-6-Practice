package com.practice.springsecurity.dao;

import com.practice.springsecurity.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//@Entity //Marking it as @Component for the development purpose
public class UserDao {

    //Below initialization is only for development purpose
    List<User> userList = new ArrayList<>();
    public UserDao(){
        this.userList.add(new User("user","1234"));
        this.userList.add(new User("admin","1234"));
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

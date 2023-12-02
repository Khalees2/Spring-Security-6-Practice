package com.practice.springsecurity.security;

import com.practice.springsecurity.model.User;
import com.practice.springsecurity.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringSecBasicAuthenticationProvider implements AuthenticationProvider {

    private UserService userService;

    public SpringSecBasicAuthenticationProvider(UserService userService){
        this.userService = userService;
    }
    //Custom Authentication Provider logic for our application
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //Define our authentication logic here.
        String userId = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = this.userService.getUserById(userId);
        //We will have to use some form of password encryption/hashing methods to compare passwords.
        //We should not be matching raw password.
        if(user!=null && user.getPassword().equals(password)){
            List<GrantedAuthority> authorities = new ArrayList<>();
            //add all the roles of this user. But here for dev purpose we are adding first role.
            authorities.add(new SimpleGrantedAuthority(user.getRoles().get(0)));
            return new UsernamePasswordAuthenticationToken(userId,password,authorities);
        }else{
            throw new BadCredentialsException("Invalid Password");
        }
    }

    //This is required to inform ProviderManager what kind of authentication is supported
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}

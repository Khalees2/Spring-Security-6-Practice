package com.practice.springsecurity.security;

import com.practice.springsecurity.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

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

        return null;
    }

    //This is required to inform ProviderManager what kind of authentication is supported
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}

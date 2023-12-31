package com.practice.springsecurity.security;

import com.practice.springsecurity.security.filter.SpringSecBasicFilterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecBasicConfiguration {
    //Below Bean configuration is implemented to demonstrate how we can allow/specify URL patterns before authentication happens.
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests((requests) -> {
            //Below method if we want to deny all requests - not recommended
            //requests.requestMatchers("/**").denyAll();
            requests.requestMatchers("/accounts","/account/**").authenticated();
            requests.requestMatchers("/welcome","/about","/contact").permitAll();
        });
        http.addFilterAfter(new SpringSecBasicFilterImpl(), BasicAuthenticationFilter.class);
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}

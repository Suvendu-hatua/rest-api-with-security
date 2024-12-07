package com.spring_boot.rest_api.Rest_Api_Demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user1= User.builder()
                .username("suvendu")
                .password("{noop}test@123")
                .roles("ADMIN","PRODUCER","PUBLIC")
                .build();
        UserDetails user2=User.builder()
                .username("sonali")
                .password("{noop}test@123")
                .roles("PRODUCER","PUBLIC")
                .build();
        UserDetails user3=User.builder()
                .username("nirmal")
                .password("{noop}test@123")
                .roles("PUBLIC")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer.requestMatchers(HttpMethod.GET,"/movies").hasRole("PUBLIC")
                        .requestMatchers(HttpMethod.GET,"/movies/**").hasRole("PUBLIC")
                        .requestMatchers(HttpMethod.POST,"/movies").hasRole("PRODUCER")
                        .requestMatchers(HttpMethod.PUT,"/movies").hasRole("PRODUCER")
                        .requestMatchers(HttpMethod.DELETE,"/movies/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                );
        //Use http basic authentication
        http.httpBasic(Customizer.withDefaults());
        //Disable CSRF (Cross Site Request Forgery)---> mainly used with web Forms not used with Crud APIs.
        http.csrf(csrf->csrf.disable());
        return http.build();
    }

}

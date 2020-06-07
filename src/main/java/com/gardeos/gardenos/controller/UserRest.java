package com.gardeos.gardenos.controller;

import com.gardeos.gardenos.entity.User;
import com.gardeos.gardenos.security.UserPrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRest {

    @Autowired
    UserPrincipalDetailsService userPrincipalDetailsService;

    @GetMapping("/user")
    public List<User> getUser(){
        return userPrincipalDetailsService.getUser();
    }

    @GetMapping("/activeuser")
    public UserDetails getUserActive(){
        UserDetails userDetails;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return (UserDetails)auth.getPrincipal();
        }
        return null;
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userPrincipalDetailsService.saveUserWithNonEncodedPassword(user);
    }


}

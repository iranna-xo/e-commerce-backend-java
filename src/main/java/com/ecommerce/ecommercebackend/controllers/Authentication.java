package com.ecommerce.ecommercebackend.controllers;


import com.ecommerce.ecommercebackend.models.User;
import com.ecommerce.ecommercebackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class Authentication {


    @Autowired
    AuthService authService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    //returning a session id for now can add to return a session cookie
    @PostMapping("/sign-up")
    public String signUp(@RequestBody User user){
        authService.saveUserAsCustomer(user);
        return "000000";
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestBody User user){
        String sessionkey="";
        try {
            sessionkey = authService.authenticateUser(user.getUsername(), user.getPassword());
        }catch (RuntimeException e){
            if(e.getMessage()== "User not found"){
                return e.getMessage();
            }
            if(e.getMessage() == "Password don't match"){
                return e.getMessage();
            }
        }
        return  sessionkey;
    }
}

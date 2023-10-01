package com.ecommerce.ecommercebackend.service;

import com.ecommerce.ecommercebackend.models.ERole;
import com.ecommerce.ecommercebackend.models.User;
import com.ecommerce.ecommercebackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    UserRepo userRepo;

    public User saveUserAsCustomer(User user){

        user.setRole(ERole.ROLE_CUSTOMER);

        return userRepo.save(user);
    }

    //and return session key later can be made to return cookies
    public String authenticateUser(String email, String password){
        User user = userRepo.findByusername(email).orElseThrow(()->{
            throw new RuntimeException("User not found");
        });
        if(user.getPassword().equals(password)){
            return "00000";
        }
        else
            throw new RuntimeException("Password don't match");

    }

}

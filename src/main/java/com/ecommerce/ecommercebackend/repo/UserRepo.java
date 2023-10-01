package com.ecommerce.ecommercebackend.repo;


import com.ecommerce.ecommercebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByusername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}

package com.recipesharingapp.recipeshare.Repository;

import com.recipesharingapp.recipeshare.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public  User findByEmail(String email);
}

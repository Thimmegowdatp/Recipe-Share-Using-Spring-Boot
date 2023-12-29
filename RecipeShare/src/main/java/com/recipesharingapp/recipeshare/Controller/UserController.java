package com.recipesharingapp.recipeshare.Controller;

import com.recipesharingapp.recipeshare.Model.User;
import com.recipesharingapp.recipeshare.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
     private UserRepository userRepository;


    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) throws Exception {
          User isExist = userRepository.findByEmail( user.getEmail());

          if (isExist != null) {
              throw  new Exception("User Already Exist: With this: " +user.getEmail());
          }else
              return userRepository.save(user);
    }
}

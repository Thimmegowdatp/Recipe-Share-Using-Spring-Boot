package com.recipesharingapp.recipeshare.Service;

import com.recipesharingapp.recipeshare.Model.User;
import com.recipesharingapp.recipeshare.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



public interface UserService  {

    public User findUserByID(long userId) throws Exception;

    }

package com.recipesharingapp.recipeshare.Service;

import com.recipesharingapp.recipeshare.Model.User;
import com.recipesharingapp.recipeshare.Repository.RecipeRepository;
import com.recipesharingapp.recipeshare.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImplimentation  implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUserByID(long userId) throws Exception {
        Optional<User> opt= userRepository.findById(userId);
        if (opt.isPresent() ) {
            return opt.get();
        }
        throw new Exception("This User ID Is Not Present: "+userId);
    }
}

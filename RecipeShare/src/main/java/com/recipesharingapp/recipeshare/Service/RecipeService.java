package com.recipesharingapp.recipeshare.Service;

import com.recipesharingapp.recipeshare.Model.Recipe;
import com.recipesharingapp.recipeshare.Model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
@Service
public interface RecipeService {
    public Recipe createRecipe(Recipe recipe, User user);
    public Recipe findRecipe(long id) throws  Exception;
    public void deleteRecipe(long id) throws  Exception;
    public Recipe updateRecipe(Recipe recipe, long id) throws Exception;

    public List<Recipe>  findAllRecipe();
    public Recipe LikeRecipe(long RecipeId, User user) throws  Exception;

}

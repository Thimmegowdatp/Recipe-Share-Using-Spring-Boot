package com.recipesharingapp.recipeshare.Controller;

import com.recipesharingapp.recipeshare.Model.Recipe;
import com.recipesharingapp.recipeshare.Model.User;
import com.recipesharingapp.recipeshare.Service.RecipeService;
import com.recipesharingapp.recipeshare.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RecipeRestController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;


    @PostMapping("/api/recipe/createRecipe/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe,@PathVariable long userId) throws Exception {
        User user= userService.findUserByID(userId);
        return recipeService.createRecipe(recipe, user);
    }

    @GetMapping("/api/recipe/findRecipeById/{id}")
    public Recipe findRecipe(@PathVariable long id) throws  Exception{
        return recipeService.findRecipe(id);
    }

    @DeleteMapping("/api/recipe/deleteRecipeById/{id}")
    public void deleteRecipe(@PathVariable long id) throws  Exception{
        recipeService.deleteRecipe(id);
    }

    @PutMapping("/api/recipe/updateRecipe/{id}")
    public Recipe updateRecipe(@RequestBody  Recipe recipe,@PathVariable long id) throws Exception{
        return recipeService.updateRecipe(recipe,id);
    }


    @GetMapping("/api/recipe/findAllRecipe")
    public List<Recipe> findAllRecipe(){
        return recipeService.findAllRecipe();
    }

    @PutMapping("/api/recipe/likeRecipe/{RecipeId}/user/{userId}")
    public Recipe LikeRecipe(@PathVariable long RecipeId, @PathVariable  long userId) throws  Exception{
        User user= userService.findUserByID(userId);
        return recipeService.LikeRecipe(RecipeId, user);
    }
}

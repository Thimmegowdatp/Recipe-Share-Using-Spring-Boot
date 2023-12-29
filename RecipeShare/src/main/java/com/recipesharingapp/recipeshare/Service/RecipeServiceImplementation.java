package com.recipesharingapp.recipeshare.Service;

import com.recipesharingapp.recipeshare.Model.Recipe;
import com.recipesharingapp.recipeshare.Model.User;
import com.recipesharingapp.recipeshare.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class RecipeServiceImplementation implements RecipeService {

    @Autowired
    private  RecipeRepository recipeRepository;

    @Override
    public Recipe createRecipe(Recipe recipe, User user) {
        Recipe  createdRecipe =new Recipe();
        createdRecipe.setTitle(recipe.getTitle());
        createdRecipe.setImage(recipe.getImage());
        createdRecipe.setUser(user);
//        createdRecipe.setCreatedAt(recipe.getCreatedAt());

        createdRecipe.setVegitarion(recipe.isVegitarion());
        createdRecipe.setDescription(recipe.getDescription());
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        createdRecipe.setCreatedAt(LocalDateTime.now());
        return recipeRepository.save(createdRecipe);
    }

    @Override
    public Recipe findRecipe(long id) throws Exception {
        Optional<Recipe> findRecipe = recipeRepository.findById(id);
        if (findRecipe.isPresent()) {
            return  findRecipe.get();

        }
        throw  new Exception("Recipe Not FOund In THis Id: "+id);
    }

    @Override
    public void deleteRecipe(long id) throws Exception {
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, long id) throws Exception {
       Recipe uR= findRecipe(id);

        if (recipe.getDescription() != null) {
            uR.setDescription(recipe.getDescription());
        }
        if(recipe.getTitle() != null){
            uR.setImage(recipe.getImage());
        }
        if (recipe.getImage() != null) {
            uR.setImage(recipe.getImage());
        }
            uR.setCreatedAt(LocalDateTime.now());
        return uR;

    }

    @Override
    public List<Recipe> findAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe LikeRecipe(long RecipeId, User user) throws Exception {
        Recipe like = findRecipe(RecipeId);
        if (like.getLikes().contains(user.getId())) {
            like.getLikes().remove(user.getId());
        } else{
            like.getLikes().add(user.getId());
    }
        return recipeRepository.save(like);
    }

}

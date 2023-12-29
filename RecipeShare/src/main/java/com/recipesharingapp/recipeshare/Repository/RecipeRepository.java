package com.recipesharingapp.recipeshare.Repository;

import com.recipesharingapp.recipeshare.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}

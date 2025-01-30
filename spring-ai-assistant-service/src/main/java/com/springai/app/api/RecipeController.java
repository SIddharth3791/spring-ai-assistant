package com.springai.app.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springai.app.model.RecipeRequest;
import com.springai.app.service.recipe.RecipeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RecipeController {
	
	private final RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	
	@GetMapping("/create/recipe")
	public String createFoodRecipe(@RequestBody RecipeRequest recipeRequest ) {
		log.info("Calling Create Food Recipe Service with Prompt:  {}", recipeRequest);
		return recipeService.createFoodRecipe(recipeRequest.getIngridients(), 
											  recipeRequest.getCuisine(), 
											  recipeRequest.getDietaryRestriction());
	}

}

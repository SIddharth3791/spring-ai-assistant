package com.springai.app.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springai.app.model.RecipeRequest;
import com.springai.app.service.recipe.RecipeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
public class RecipeController {
	
	private final RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	
	@PostMapping("/create/recipe")
	public String createFoodRecipe(@RequestBody RecipeRequest recipeRequest ) {
		log.info("Calling Create Food Recipe Service with Prompt:  {}", recipeRequest);
		return recipeService.createFoodRecipe(recipeRequest.getIngridients(), 
											  recipeRequest.getCuisine(), 
											  recipeRequest.getDietaryRestriction());
	}

}

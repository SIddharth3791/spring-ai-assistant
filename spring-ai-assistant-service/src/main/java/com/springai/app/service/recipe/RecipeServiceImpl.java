package com.springai.app.service.recipe;

import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

	private ChatModel chatModel;
	
	@Value("classpath:templates/food_recipe.st")
	private Resource receipeTemplate;
	
	
	public RecipeServiceImpl(ChatModel chatModel) {
		this.chatModel  = chatModel;
	}


	@Override
	public String createFoodRecipe(String ingridients, String cuisine, String dietaryRestriction) {
		
		PromptTemplate promptTemplate = new PromptTemplate(receipeTemplate);
		
		Map<String, Object> mapOfPrompts = Map.of(	"ingridients", ingridients ,
													"cuisine", cuisine , 
													"dietaryRestriction",dietaryRestriction);
		
		Prompt prompt = promptTemplate.create(mapOfPrompts);
		
		ChatResponse response = chatModel.call(prompt);
		
		
		return response.getResult().getOutput().getContent();
	}
	
	


}

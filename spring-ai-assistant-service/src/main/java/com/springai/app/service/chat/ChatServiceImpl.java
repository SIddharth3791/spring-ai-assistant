package com.springai.app.service.chat;

import java.util.List;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl  implements ChatService{

	private ChatModel chatModel;
	
	
	public ChatServiceImpl(ChatModel chatModel) {
		this.chatModel = chatModel;
	}
	
	@Override
	public String getResponseFromAi(String question) {
		
		var option = OpenAiChatOptions.builder().model(OpenAiApi.ChatModel.GPT_4_TURBO).temperature(0.4D).build();
		
		Message userMsg = new PromptTemplate(question).createMessage();
		
		Prompt prompt = new Prompt(List.of(userMsg),option);
		
		ChatResponse response = chatModel.call(prompt);
		
		return response.getResult().getOutput().getContent();
	}	

}

package com.springai.app.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springai.app.service.chat.ChatService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GenAiController {
	
	private ChatService chatService;
	
	public GenAiController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	
	@GetMapping("/ask")
	public String askMeAnything(@RequestParam String prompt) {
		log.info("Calling Chat Service with Prompt:  {}", prompt);
		return chatService.getResponseFromAi(prompt);
	}

}

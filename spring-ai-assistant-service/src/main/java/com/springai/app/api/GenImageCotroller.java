package com.springai.app.api;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springai.app.service.image.ImageGenService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GenImageCotroller {
	
	private final ImageGenService imgGenService;
	
	public GenImageCotroller(ImageGenService imgGenService) {
		this.imgGenService = imgGenService;
	}
	
	@GetMapping(value = "/createImg")
	public List<String> generateImage(@RequestParam String imageIdea) {
		log.info("Calling Create Image Service with Prompt:  {}", imageIdea);
		return imgGenService.generateImage(imageIdea);
	}
	

}

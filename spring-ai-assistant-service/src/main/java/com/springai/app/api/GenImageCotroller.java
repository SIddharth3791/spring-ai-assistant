package com.springai.app.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springai.app.service.image.ImageGenService;

@RestController
public class GenImageCotroller {
	
	private final ImageGenService imgGenService;
	
	public GenImageCotroller(ImageGenService imgGenService) {
		this.imgGenService = imgGenService;
	}
	
	@PostMapping(value = "/createImg", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] generateImage(@RequestParam String imageIdea) {
		return imgGenService.generateImage(imageIdea);
	}

}

package com.springai.app.service.image;


import java.util.Base64;
import java.util.List;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

import com.springai.app.model.ImageGenProperty;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImageGenServiceImpl implements ImageGenService {

	private OpenAiImageModel aiImageModel;
	
	private ImageGenProperty imageGenProperty;
	
	public ImageGenServiceImpl(OpenAiImageModel aiImageModel, ImageGenProperty imageGenProperty) {
		this.aiImageModel = aiImageModel;
		this.imageGenProperty = imageGenProperty;
	}
	
	@Override
	public List<String> generateImage(String question) {
		var imageOption = OpenAiImageOptions.builder()
				.height(imageGenProperty.getHeight())
				.width(imageGenProperty.getHeight())
				.model(imageGenProperty.getModelType())
				.quality(imageGenProperty.getQuality())
				.N(imageGenProperty.getNumberOfImg())
				.build();
		
		ImagePrompt imagePrompt = new ImagePrompt(question, imageOption);
	
		var imgResponse  = aiImageModel.call(imagePrompt);
		
		List<String> imageUrls = imgResponse.getResults().stream()
                .map(result -> result.getOutput().getUrl())
                .toList();
	
		
		log.info("IMAGE URLS : {}", imageUrls);
		return imageUrls;
	}

}

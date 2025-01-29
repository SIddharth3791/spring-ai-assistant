package com.springai.app.service.image;


import java.util.Base64;
import java.util.List;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

import com.springai.app.model.ImageGenProperty;

@Service
public class ImageGenServiceImpl implements ImageGenService {

	private OpenAiImageModel aiImageModel;
	
	private ImageGenProperty imageGenProperty;
	
	public ImageGenServiceImpl(OpenAiImageModel aiImageModel, ImageGenProperty imageGenProperty) {
		this.aiImageModel = aiImageModel;
		this.imageGenProperty = imageGenProperty;
	}
	
	@Override
	public byte[] generateImage(String question) {
		var imageOption = OpenAiImageOptions.builder()
				.responseFormat(imageGenProperty.getResponseFormat())
				.height(imageGenProperty.getHeight())
				.width(imageGenProperty.getHeight())
				.model(imageGenProperty.getModelType())
				.quality(imageGenProperty.getQuality())
				.build();
		
		ImagePrompt imagePrompt = new ImagePrompt(question, imageOption);
		
		var response  = aiImageModel.call(imagePrompt);
		
		return Base64.getDecoder().decode(response.getResult().getOutput().getB64Json());
	}

}

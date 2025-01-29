package com.springai.app.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix ="img")
public class ImageGenProperty {
	
	String responseFormat;
	
	String modelType;
	
	String quality;
	
	String style;
	
	int height;
	
	int width;

}

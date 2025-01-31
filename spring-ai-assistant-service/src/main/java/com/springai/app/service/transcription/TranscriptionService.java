package com.springai.app.service.transcription;

import org.springframework.web.multipart.MultipartFile;

public interface TranscriptionService {
	
	String transcribeAudio(MultipartFile file);

}

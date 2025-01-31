package com.springai.app.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springai.app.service.transcription.TranscriptionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class TranscriptionController {
	
	private final TranscriptionService transcriptionService;
	
	public TranscriptionController(TranscriptionService transcriptionService) {
		this.transcriptionService = transcriptionService;
	}
	
	@PostMapping("/transcribe/audio")
	public ResponseEntity<String> postMethodName(@RequestParam("file") MultipartFile file) {
	
			String transcribedRes = transcriptionService.transcribeAudio(file);
		
		return ResponseEntity.ok(transcribedRes);
	}
	

}

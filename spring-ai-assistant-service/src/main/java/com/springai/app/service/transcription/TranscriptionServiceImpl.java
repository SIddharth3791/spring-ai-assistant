package com.springai.app.service.transcription;

import java.io.File;
import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.api.OpenAiAudioApi.TranscriptResponseFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TranscriptionServiceImpl implements TranscriptionService {
	
	private final OpenAiAudioTranscriptionModel aiAudioTranscriptionModel;
	
	
	public TranscriptionServiceImpl(@Value("${spring.ai.openai.api-key}") String apikey) {
		OpenAiAudioApi aiAudioApi = new OpenAiAudioApi(System.getenv("OPENAI_API_KEY"));
		this.aiAudioTranscriptionModel = new OpenAiAudioTranscriptionModel(aiAudioApi);
	}

	@Override
	public String transcribeAudio(MultipartFile file) {
		
		try {
			File workingAudioFile = File.createTempFile("audio", ".wav");
			file.transferTo(workingAudioFile);
			
			OpenAiAudioTranscriptionOptions transcriptionOption = OpenAiAudioTranscriptionOptions.builder()
										.responseFormat(TranscriptResponseFormat.TEXT)
										.language("en")
										.temperature(0f)
										.build();
			
			var audioFile = new FileSystemResource(workingAudioFile);
			
			AudioTranscriptionPrompt audioPromptRequest = new AudioTranscriptionPrompt(audioFile, transcriptionOption);
			
			var transcribeResponse = aiAudioTranscriptionModel.call(audioPromptRequest);
			
			workingAudioFile.delete();
			
			return transcribeResponse.getResult().getOutput();
			
		} catch (Exception err) {
			// TODO Auto-generated catch block
			log.error("Issue While Transcribing Audio File", err);
			return null;
		}
	}

}

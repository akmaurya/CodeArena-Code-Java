package com.listentowords;

import javax.sound.sampled.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;

public class ListenToWordsMain {

	public static void main(String[] args) throws LineUnavailableException, IOException {
		// Set up audio capture
        /*AudioFormat format = new AudioFormat(16000, 16, 1, true, false);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
        line.open(format);
        line.start();

        // Capture audio
        System.out.println("Listening... Speak something.");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[16000];
        int numBytesRead;
        while ((numBytesRead = line.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, numBytesRead);
        }

        // Convert audio to text using Google Cloud Speech-to-Text API
        try (SpeechClient speechClient = SpeechClient.create()) {
            ByteString audioBytes = ByteString.copyFrom(out.toByteArray());
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setSampleRateHertz(16000)
                    .setLanguageCode("en-US")
                    .build();
            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

            RecognizeResponse response = speechClient.recognize(config, audio);
            for (SpeechRecognitionResult result : response.getResultsList()) {
                System.out.printf("Transcription: %s%n", result.getAlternativesList().get(0).getTranscript());
            }
        } catch (Exception e) {
            System.err.println("Failed to transcribe audio: " + e.getMessage());
        }

	}*/
		
		// Path to the audio file
        String audioFilePath = "C:/Users/arvin/Desktop/FL_Export/Combined_Hamari Adhuri Kahani.mp3";

        // Read audio file as bytes
        byte[] audioBytes = Files.readAllBytes(Paths.get(audioFilePath));

        // Convert audio to text using Google Cloud Speech-to-Text API
        try (SpeechClient speechClient = SpeechClient.create()) {
            ByteString audioData = ByteString.copyFrom(audioBytes);
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setSampleRateHertz(16000)
                    .setLanguageCode("en-US")
                    .build();
            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioData).build();

            RecognizeResponse response = speechClient.recognize(config, audio);
            for (SpeechRecognitionResult result : response.getResultsList()) {
                System.out.printf("Transcription: %s%n", result.getAlternativesList().get(0).getTranscript());
            }
        } catch (Exception e) {
            System.err.println("Failed to transcribe audio: " + e.getMessage());
        }
    }

}

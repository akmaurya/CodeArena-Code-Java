package com.xcode.javas.myproject.listen;
import javax.sound.sampled.*;
import java.io.*;
import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;

public class ListenMain {

	public static void main(String[] args) throws Exception {

        // Set up audio capture
        AudioFormat format = new AudioFormat(16000, 16, 1, true, false);
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
    }
}

package com.example.BackendTask.service;

import com.example.BackendTask.entity.ChatGPTRequest;
import com.example.BackendTask.entity.ChatGPTResponse;
import com.example.BackendTask.entity.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChatGPTService {

    private String apiKey="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";

    private static final String OPEN_AI_CHAT_ENDPOINT = "https://api.openai.com/v1/chat/completions";

    private RestTemplate restTemplate;

    public ChatGPTService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ChatGPTResponse getChatCPTResponse(String prompt) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " +  apiKey);

        ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
        chatGPTRequest.setModel("gpt-3.5-turbo");
        chatGPTRequest.setMessages(List.of(new Message("user", prompt)));
        chatGPTRequest.setMax_tokens(50);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ChatGPTRequest> request = new HttpEntity<>(chatGPTRequest, headers);

        return restTemplate.postForObject(OPEN_AI_CHAT_ENDPOINT, request, ChatGPTResponse.class);
    }
}
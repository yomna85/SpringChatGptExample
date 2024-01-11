package com.example.BackendTask.entity;

import java.util.List;

public class ChatGPTResponse {

    public String id;
    public String object;
    public int created;
    public List<Choice> choices;
    public Usage usage;

}

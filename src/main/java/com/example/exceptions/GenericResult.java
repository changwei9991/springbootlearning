package com.example.exceptions;

public class GenericResult{
    private String message;
    public GenericResult(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

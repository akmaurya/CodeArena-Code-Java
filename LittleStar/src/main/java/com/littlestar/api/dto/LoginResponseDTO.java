package com.littlestar.api.dto;

public class LoginResponseDTO {
	private String email;
    private String message;

    public LoginResponseDTO(String email, String message) {
        this.email = email;
        this.message = message;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

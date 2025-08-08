package com.dfbf.soundlink.user.application.port.in.response;

public record CreateUserResponse(String message) {
    public static CreateUserResponse success() {
        return new CreateUserResponse("Registration successful");
    }

    public static CreateUserResponse fail(String errorMessage) {
        return new CreateUserResponse("Registration failed: " + errorMessage);
    }
}

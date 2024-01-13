package com.counterstrike.cs.http_error;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public class ErrorMessage {
    private String message;
    private int code;

    public ErrorMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }
}

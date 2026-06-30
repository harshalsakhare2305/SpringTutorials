package org.ticketbookingapi.model;

import java.time.LocalDateTime;

public class ErrorDetails {

    private String message;

    private LocalDateTime time;


    public ErrorDetails(String message, LocalDateTime time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "message='" + message + '\'' +
                ", time=" + time +
                '}';
    }

    public ErrorDetails setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public ErrorDetails setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }
}

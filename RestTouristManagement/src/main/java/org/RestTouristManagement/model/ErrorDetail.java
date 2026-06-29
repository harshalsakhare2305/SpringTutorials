package org.RestTouristManagement.model;

import java.time.LocalDateTime;

public class ErrorDetail {

    private String message;

    private String statusCode;

    private LocalDateTime localDateTime;


    public ErrorDetail(String message, String statusCode, LocalDateTime localDateTime) {
        this.message = message;
        this.statusCode = statusCode;
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDetail setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ErrorDetail setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public ErrorDetail setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }
}

package com.example.shop.controllers;

public enum RequestStatus {
    OK("Responce code = 200"),
    UNEXPECTED_ERROR("Status response code - unexpected error"),
    ERROR_500("Response code = 500"),
    ERROR_300("Response code = 300"),
    ERROR_400("Response code = 400");

    private String status;

    RequestStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

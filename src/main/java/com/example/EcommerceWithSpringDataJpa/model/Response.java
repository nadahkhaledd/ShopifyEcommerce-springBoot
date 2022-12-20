package com.example.EcommerceWithSpringDataJpa.model;

public class Response<T> {
    private String message;
    private int statusCode;

    private T objectToBeReturned;

    public T getObjectToBeReturned() {
        return objectToBeReturned;
    }

    public void setObjectToBeReturned(T objectToBeReturned) {
        this.objectToBeReturned = objectToBeReturned;
    }

    public Response(String message, int statusCode, T objectToBeReturned) {
        this.message = message;
        this.statusCode = statusCode;
        this.objectToBeReturned = objectToBeReturned;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}

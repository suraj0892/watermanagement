package com.example.geektrust.exceptions;

public class ApartmentNotFoundException extends RuntimeException{

    public ApartmentNotFoundException(String message) {
        super(message);
    }
}

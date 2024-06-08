package com.gen4.pas.survival.exceptions;

public class BadRequestException extends Exception {
    public BadRequestException() {}

    public BadRequestException(String parameter, String value) {
        super("Missing or malformed mandatory parameter: " + parameter + "\nValue: " + value);
    }
}

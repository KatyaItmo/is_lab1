package org.example.is_lab1.exceptions;

public class OccupiedUsernameException extends RuntimeException {
    public OccupiedUsernameException(String message) {
        super(message);
    }
}

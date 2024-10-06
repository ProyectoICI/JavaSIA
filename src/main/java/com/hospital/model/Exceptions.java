package main.java.com.hospital.model;

public class Exceptions {

    public static class InvalidUserInputException extends Exception {
        public InvalidUserInputException(String message) {
            super(message);
        }
    }

    public static class DatabaseConnectionException extends RuntimeException {
        public DatabaseConnectionException(String message) {
            super(message);
        }
    }
}


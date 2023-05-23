package com.savely.courseproject2.exception;

public class AmountIsTooLargeException extends RuntimeException {
    public AmountIsTooLargeException(String message) {
        super(message);
    }
}

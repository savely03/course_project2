package com.savely.courseproject2.exception;

public class QuestionAlreadyAddedException extends RuntimeException {
    public QuestionAlreadyAddedException(String message) {
        super(message);
    }
}

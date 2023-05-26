package com.savely.courseproject2.handler;

import com.savely.courseproject2.exception.AmountIsTooLargeException;
import com.savely.courseproject2.exception.ListOfQuestionsIsEmptyException;
import com.savely.courseproject2.exception.QuestionAlreadyAddedException;
import com.savely.courseproject2.exception.QuestionNotFoundException;
import com.savely.courseproject2.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(AmountIsTooLargeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleAmountsIsTooLargeEx(AmountIsTooLargeException e) {
        return new Response(e.getMessage());
    }

    @ExceptionHandler(ListOfQuestionsIsEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleListOfQuestionsIsEmptyEx(ListOfQuestionsIsEmptyException e) {
        return new Response(e.getMessage());
    }

    @ExceptionHandler(QuestionAlreadyAddedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleQuestionAlreadyAddedEx(QuestionAlreadyAddedException e) {
        return new Response(e.getMessage());
    }

    @ExceptionHandler(QuestionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handleQuestionNotFoundEx(QuestionNotFoundException e) {
        return new Response(e.getMessage());
    }

}

package com.savely.courseproject2.service.impl;

import com.savely.courseproject2.exception.AmountIsTooLargeException;
import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.service.ExaminerService;
import com.savely.courseproject2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    private Collection<Question> getQuestions(int amount, QuestionService questionService) {
        Set<Question> uniqueQuestions = new HashSet<>();

        if (questionService.getAll().size() < amount) {
            throw new AmountIsTooLargeException("Слишком большое количество вопросов!");
        }

        while (uniqueQuestions.size() < amount) {
            uniqueQuestions.add(questionService.getRandomQuestion());
        }

        return uniqueQuestions;
    }

    @Override
    public Collection<Question> getJavaQuestions(int amount) {
        return getQuestions(amount, javaQuestionService);
    }

    @Override
    public Collection<Question> getMathQuestions(int amount) {
        return getQuestions(amount, mathQuestionService);
    }

}

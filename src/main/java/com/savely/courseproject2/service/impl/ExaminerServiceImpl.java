package com.savely.courseproject2.service.impl;

import com.savely.courseproject2.exception.AmountIsTooLargeException;
import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.service.ExaminerService;
import com.savely.courseproject2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private final Set<Question> uniqueQuestions;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        this.uniqueQuestions = new HashSet<>();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new AmountIsTooLargeException("Слишком большое количество вопросов!");
        }

        while (uniqueQuestions.size() < amount) {
            uniqueQuestions.add(questionService.getRandomQuestion());
        }

        return uniqueQuestions;
    }
}

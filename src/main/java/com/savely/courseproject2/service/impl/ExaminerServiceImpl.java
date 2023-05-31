package com.savely.courseproject2.service.impl;

import com.savely.courseproject2.exception.AmountIsTooLargeException;
import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.service.ExaminerService;
import com.savely.courseproject2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices;
    private final Random random;

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        questionServices = new ArrayList<>();
        random = new Random();
        questionServices.add(javaQuestionService);
        questionServices.add(mathQuestionService);

    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> uniqueQuestions = new HashSet<>();
        int questionsAmount = questionServices.stream().mapToInt(QuestionService::getQuestionsAmount).sum();

        if (questionsAmount < amount) {
            throw new AmountIsTooLargeException("Слишком большое количество вопросов!");
        }

        while (uniqueQuestions.size() < amount) {
            uniqueQuestions.add(questionServices.get(random.nextInt(questionServices.size())).getRandomQuestion());
        }

        return uniqueQuestions;
    }

}

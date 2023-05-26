package com.savely.courseproject2.service.impl;

import com.savely.courseproject2.exception.ListOfQuestionsIsEmptyException;
import com.savely.courseproject2.exception.QuestionAlreadyAddedException;
import com.savely.courseproject2.exception.QuestionNotFoundException;
import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.service.QuestionService;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions;

    private final Random random;

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (!questions.contains(newQuestion)) {
            questions.add(newQuestion);
            return newQuestion;
        }
        throw new QuestionAlreadyAddedException("Такой вопрос уже существует!");
    }

    @Override
    public Question remove(String question, String answer) {
        Question removeQuestion = new Question(question, answer);
        if (questions.remove(removeQuestion)) {
            return removeQuestion;
        }
        throw new QuestionNotFoundException("Такого вопроса не существует!");
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.size() > 0) {
            return questions.get(random.nextInt(questions.size()));
        }
        throw new ListOfQuestionsIsEmptyException("Список вопросов пуст!");
    }
}

package com.savely.courseproject2.service.impl;

import com.savely.courseproject2.exception.MethodNotAllowedException;
import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final List<String> questions;

    private final List<String> answers;

    private final Random random;

    public MathQuestionService(@Qualifier("getQuestions") List<String> questions,
                               @Qualifier("getAnswers") List<String> answers) {
        this.questions = questions;
        this.answers = answers;
        random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Данный метод не поддерживается");
    }

    @Override
    public Question remove(String question, String answer) {
        throw new MethodNotAllowedException("Данный метод не поддерживается");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Данный метод не поддерживается");
    }


    private Collection<Question> createMathQuestions() {
        Set<Question> mathQuestions = new HashSet<>();

        while (mathQuestions.size() < getQuestionsAmount()) {
            String question = questions.get(random.nextInt(questions.size()));
            String answer = answers.get(random.nextInt(answers.size()));
            mathQuestions.add(new Question(question, answer));
        }

        return mathQuestions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> mathQuestions = new ArrayList<>(createMathQuestions());
        return mathQuestions.get(random.nextInt(mathQuestions.size()));
    }

    @Override
    public int getQuestionsAmount() {
        return questions.size();
    }

}

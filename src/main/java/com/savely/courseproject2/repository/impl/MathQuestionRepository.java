package com.savely.courseproject2.repository.impl;

import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final List<Question> mathQuestions;

    public MathQuestionRepository() {
        mathQuestions = new ArrayList<>();
    }

    @PostConstruct
    private void init() {
        for (int i = 1; i <= 5; i++) {
            mathQuestions.add(new Question("math question" + i, "math answer" + i));
        }
    }

    @Override
    public boolean contains(Question question) {
        return mathQuestions.contains(question);
    }

    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(mathQuestions);
    }
}

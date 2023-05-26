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
public class JavaQuestionRepository implements QuestionRepository {

    private final List<Question> javaQuestions;

    public JavaQuestionRepository() {
        this.javaQuestions = new ArrayList<>();
    }

    @PostConstruct
    private void init() {
        for (int i = 1; i <= 5; i++) {
            javaQuestions.add(new Question("java question" + i, "java answer" + i));
        }
    }

    @Override
    public boolean contains(Question question) {
        return javaQuestions.contains(question);
    }

    @Override
    public Question add(Question question) {
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        javaQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(javaQuestions);
    }
}

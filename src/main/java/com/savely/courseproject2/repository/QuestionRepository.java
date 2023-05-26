package com.savely.courseproject2.repository;

import com.savely.courseproject2.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    boolean contains(Question question);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}

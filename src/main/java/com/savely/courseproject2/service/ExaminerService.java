package com.savely.courseproject2.service;

import com.savely.courseproject2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getJavaQuestions(int amount);

    Collection<Question> getMathQuestions(int amount);

}

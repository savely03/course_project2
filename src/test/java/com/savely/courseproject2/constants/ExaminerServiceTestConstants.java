package com.savely.courseproject2.constants;

import com.savely.courseproject2.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ExaminerServiceTestConstants {

    public final static List<Question> QUESTIONS = new ArrayList<>();

    static {
        Stream.iterate(1, i -> i + 1)
                .limit(5)
                .forEach(i -> QUESTIONS.add(new Question("question" + i, "answer" + i)));

    }
}

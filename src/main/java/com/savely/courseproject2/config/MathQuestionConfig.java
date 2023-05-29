package com.savely.courseproject2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class MathQuestionConfig {

    @Bean
    public List<String> getQuestions() {
        List<String> questions = new ArrayList<>();
        Stream.iterate(1, i -> i + 1)
                .limit(5)
                .forEach(i -> questions.add("question" + i));
        return questions;
    }

    @Bean
    public List<String> getAnswers() {
        List<String> answers = new ArrayList<>();
        Stream.iterate(1, i -> i + 1)
                .limit(5)
                .forEach(i -> answers.add("answer" + i));
        return answers;
    }

}

package com.savely.courseproject2.repository.impl;

import com.savely.courseproject2.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.savely.courseproject2.constants.JavaQuestionServiceTestConstants.QUESTION_OBJECT;
import static com.savely.courseproject2.constants.MathQuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class MathQuestionRepositoryTest {

    private final QuestionRepository questionRepository = new MathQuestionRepository();

    @BeforeEach
    void setUp() {
        questionRepository.add(MATH_QUESTION_OBJECT);
    }

    @Test
    void containsTest() {
        assertThat(questionRepository.contains(MATH_QUESTION_OBJECT)).isTrue();
        assertThat(questionRepository.contains(QUESTION_OBJECT)).isFalse();
    }

    @Test
    void add() {
        int initialSize = questionRepository.getAll().size();

        assertThat(questionRepository.add(MATH_QUESTION_OBJECT)).isEqualTo(MATH_QUESTION_OBJECT);
        assertThat(questionRepository.getAll()).hasSize(initialSize + 1);
    }

    @Test
    void remove() {
        int initialSize = questionRepository.getAll().size();

        assertThat(questionRepository.remove(MATH_QUESTION_OBJECT)).isEqualTo(MATH_QUESTION_OBJECT);
        assertThat(questionRepository.getAll()).hasSize(initialSize - 1);
    }

    @Test
    void getAll() {
        assertThat(questionRepository.getAll()).hasSize(1);
    }
}
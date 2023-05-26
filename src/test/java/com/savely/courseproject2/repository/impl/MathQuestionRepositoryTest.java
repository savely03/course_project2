package com.savely.courseproject2.repository.impl;

import com.savely.courseproject2.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.savely.courseproject2.constants.JavaQuestionServiceTestConstants.QUESTION_OBJECT;
import static com.savely.courseproject2.constants.MathQuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class MathQuestionRepositoryTest {

    private final QuestionRepository out = new MathQuestionRepository();

    @BeforeEach
    void setUp() {
        out.add(MATH_QUESTION_OBJECT);
    }

    @Test
    void containsTest() {
        assertThat(out.contains(MATH_QUESTION_OBJECT)).isTrue();
        assertThat(out.contains(QUESTION_OBJECT)).isFalse();
    }

    @Test
    void add() {
        int initialSize = out.getAll().size();

        assertThat(out.add(MATH_QUESTION_OBJECT)).isEqualTo(MATH_QUESTION_OBJECT);
        assertThat(out.getAll()).hasSize(initialSize + 1);
    }

    @Test
    void remove() {
        int initialSize = out.getAll().size();

        assertThat(out.remove(MATH_QUESTION_OBJECT)).isEqualTo(MATH_QUESTION_OBJECT);
        assertThat(out.getAll()).hasSize(initialSize - 1);
    }

    @Test
    void getAll() {
        assertThat(out.getAll()).hasSize(1).containsOnly(MATH_QUESTION_OBJECT);

    }
}
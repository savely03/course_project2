package com.savely.courseproject2.repository.impl;

import com.savely.courseproject2.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.savely.courseproject2.constants.JavaQuestionServiceTestConstants.*;
import static com.savely.courseproject2.constants.MathQuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.*;


class JavaQuestionRepositoryTest {

    private final QuestionRepository out = new JavaQuestionRepository();

    @BeforeEach
    void setUp() {
        out.add(QUESTION_OBJECT);
    }

    @Test
    void containsTest() {
        assertThat(out.contains(QUESTION_OBJECT)).isTrue();
        assertThat(out.contains(MATH_QUESTION_OBJECT)).isFalse();
    }

    @Test
    void add() {
        int initialSize = out.getAll().size();

        assertThat(out.add(QUESTION_OBJECT)).isEqualTo(QUESTION_OBJECT);
        assertThat(out.getAll()).hasSize(initialSize + 1);
    }

    @Test
    void remove() {
        int initialSize = out.getAll().size();

        assertThat(out.remove(QUESTION_OBJECT)).isEqualTo(QUESTION_OBJECT);
        assertThat(out.getAll()).hasSize(initialSize - 1);
    }

    @Test
    void getAll() {
        assertThat(out.getAll()).hasSize(1).containsOnly(QUESTION_OBJECT);
    }
}
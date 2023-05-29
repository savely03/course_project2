package com.savely.courseproject2.service.impl;

import com.savely.courseproject2.config.MathQuestionConfig;
import com.savely.courseproject2.exception.MethodNotAllowedException;
import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.service.QuestionService;
import org.junit.jupiter.api.Test;

import static com.savely.courseproject2.constants.MathQuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.*;

class MathQuestionServiceTest {

    private final MathQuestionConfig config = new MathQuestionConfig();

    private final QuestionService out = new MathQuestionService(config.getQuestions(), config.getAnswers());

    @Test
    void addTest() {
        assertThatExceptionOfType(MethodNotAllowedException.class).isThrownBy(
                () -> out.add(MATH_QUESTION, MATH_ANSWER)
        );
    }

    @Test
    void removeTest() {
        assertThatExceptionOfType(MethodNotAllowedException.class).isThrownBy(
                () -> out.remove(MATH_QUESTION, MATH_ANSWER)
        );
    }

    @Test
    void getAllTest() {
        assertThatExceptionOfType(MethodNotAllowedException.class).isThrownBy(
                out::getAll
        );

    }

    @Test
    void getRandomQuestionTest() {
        Question actual = out.getRandomQuestion();

        assertThat(actual.getQuestion()).isIn(config.getQuestions());
        assertThat(actual.getAnswer()).isIn(config.getAnswers());
    }

    @Test
    void getQuestionsAmountTest() {
        assertThat(out.getQuestionsAmount()).isEqualTo(config.getQuestions().size());
    }
}
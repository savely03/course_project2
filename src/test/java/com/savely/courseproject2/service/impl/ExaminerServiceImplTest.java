package com.savely.courseproject2.service.impl;


import com.savely.courseproject2.exception.AmountIsTooLargeException;
import com.savely.courseproject2.service.ExaminerService;
import com.savely.courseproject2.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static com.savely.courseproject2.constants.ExaminerServiceTestConstants.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    private final Random random = new Random();


    private ExaminerService out;


    @BeforeEach
    void setUp() {
        out = new ExaminerServiceImpl(List.of(questionService));
        when(questionService.getQuestionsAmount()).thenReturn(1);
    }

    @Test
    void getJavaQuestionsTest() {
        when(questionService.getRandomQuestion()).thenReturn(QUESTIONS.get(random.nextInt(QUESTIONS.size())));

        assertThat(out.getQuestions(1))
                .hasSize(1).containsAnyElementsOf(QUESTIONS);
    }

    @Test
    void getJavaQuestionWhenAmountIsTooLarge() {
        assertThatExceptionOfType(AmountIsTooLargeException.class).isThrownBy(
                () -> out.getQuestions(QUESTIONS.size() + 1)
        );
    }

    @Test
    void getMathQuestionsTest() {
        when(questionService.getRandomQuestion()).thenReturn(QUESTIONS.get(random.nextInt(QUESTIONS.size())));

        assertThat(out.getQuestions(1))
                .hasSize(1).containsAnyElementsOf(QUESTIONS);
    }

    @Test
    void getMathQuestionWhenAmountIsTooLarge() {
        assertThatExceptionOfType(AmountIsTooLargeException.class).isThrownBy(
                () -> out.getQuestions(QUESTIONS.size() + 1)
        );
    }
}
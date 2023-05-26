package com.savely.courseproject2.service.impl;


import com.savely.courseproject2.exception.AmountIsTooLargeException;
import com.savely.courseproject2.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static com.savely.courseproject2.constants.ExaminerServiceTestConstants.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    private final Random random = new Random();

    @BeforeEach
    void setUp() {
        when(questionService.getAll()).thenReturn(QUESTIONS);
    }

    @Test
    void getQuestionsTest() {
        when(questionService.getRandomQuestion()).thenReturn(QUESTIONS.get(random.nextInt(QUESTIONS.size())));

        assertThat(out.getQuestions(1))
                .hasSize(1).containsAnyElementsOf(QUESTIONS);
    }

    @Test
    void getQuestionWhenAmountIsTooLarge() {
        assertThatExceptionOfType(AmountIsTooLargeException.class).isThrownBy(
                () -> out.getQuestions(QUESTIONS.size() + 1)
        );
    }
}
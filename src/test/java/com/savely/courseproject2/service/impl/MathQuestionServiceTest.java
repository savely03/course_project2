package com.savely.courseproject2.service.impl;

import com.savely.courseproject2.exception.ListOfQuestionsIsEmptyException;
import com.savely.courseproject2.exception.QuestionAlreadyAddedException;
import com.savely.courseproject2.exception.QuestionNotFoundException;
import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.savely.courseproject2.constants.MathQuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private MathQuestionService out;

    @Test
    void addTest() {
        when(questionRepository.contains(MATH_QUESTION_OBJECT)).thenReturn(false);
        when(questionRepository.add(MATH_QUESTION_OBJECT)).thenReturn(MATH_QUESTION_OBJECT);

        assertThat(out.add(MATH_QUESTION, MATH_ANSWER)).isEqualTo(MATH_QUESTION_OBJECT);
    }

    @Test
    void addWhenQuestionAlreadyAddedTest() {
        when(questionRepository.contains(MATH_QUESTION_OBJECT)).thenReturn(true);

        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> out.add(MATH_QUESTION, MATH_ANSWER));
    }

    @Test
    void removeTest() {
        when(questionRepository.contains(MATH_QUESTION_OBJECT)).thenReturn(true);
        when(questionRepository.remove(MATH_QUESTION_OBJECT)).thenReturn(MATH_QUESTION_OBJECT);

        assertThat(out.remove(MATH_QUESTION, MATH_ANSWER)).isEqualTo(MATH_QUESTION_OBJECT);
    }

    @Test
    void removeWhenQuestionNotFoundTest() {
        when(questionRepository.contains(MATH_QUESTION_OBJECT)).thenReturn(false);

        assertThatExceptionOfType(QuestionNotFoundException.class).isThrownBy(
                () -> out.remove(MATH_QUESTION, MATH_ANSWER)
        );
    }

    @Test
    void getAllTest() {
        when(questionRepository.getAll()).thenReturn(List.of(MATH_QUESTION_OBJECT));

        assertThat(out.getAll()).hasSize(1).containsOnly(MATH_QUESTION_OBJECT);
    }

    @Test
    void getRandomQuestionTest() {
        List<Question> questions = List.of(MATH_QUESTION_OBJECT);

        when(questionRepository.getAll()).thenReturn(questions);

        assertThat(out.getRandomQuestion()).isIn(questions).isEqualTo(MATH_QUESTION_OBJECT);
    }

    @Test
    void getRandomQuestionWhenListIsEmptyTest() {
        when(questionRepository.getAll()).thenReturn(Collections.emptyList());

        assertThatExceptionOfType(ListOfQuestionsIsEmptyException.class)
                .isThrownBy(out::getRandomQuestion);
    }
}
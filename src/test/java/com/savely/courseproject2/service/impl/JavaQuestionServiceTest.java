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

import static com.savely.courseproject2.constants.JavaQuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    void addTest() {
        when(questionRepository.contains(QUESTION_OBJECT)).thenReturn(false);
        when(questionRepository.add(QUESTION_OBJECT)).thenReturn(QUESTION_OBJECT);

        assertThat(out.add(QUESTION, ANSWER)).isEqualTo(QUESTION_OBJECT);
    }

    @Test
    void addWhenQuestionAlreadyAddedTest() {
        when(questionRepository.contains(QUESTION_OBJECT)).thenReturn(true);

        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> out.add(QUESTION, ANSWER));
    }

    @Test
    void removeTest() {
        when(questionRepository.contains(QUESTION_OBJECT)).thenReturn(true);
        when(questionRepository.remove(QUESTION_OBJECT)).thenReturn(QUESTION_OBJECT);

        assertThat(out.remove(QUESTION, ANSWER)).isEqualTo(QUESTION_OBJECT);
    }

    @Test
    void removeWhenQuestionNotFoundTest() {
        when(questionRepository.contains(QUESTION_OBJECT)).thenReturn(false);

        assertThatExceptionOfType(QuestionNotFoundException.class).isThrownBy(
                () -> out.remove(QUESTION, ANSWER)
        );
    }

    @Test
    void getAllTest() {
        when(questionRepository.getAll()).thenReturn(List.of(QUESTION_OBJECT));

        assertThat(out.getAll()).hasSize(1).containsOnly(QUESTION_OBJECT);
    }

    @Test
    void getRandomQuestionTest() {
        List<Question> questions = List.of(QUESTION_OBJECT);

        when(questionRepository.getAll()).thenReturn(questions);

        assertThat(out.getRandomQuestion()).isIn(questions).isEqualTo(QUESTION_OBJECT);
    }

    @Test
    void getRandomQuestionWhenListIsEmptyTest() {
        when(questionRepository.getAll()).thenReturn(Collections.emptyList());

        assertThatExceptionOfType(ListOfQuestionsIsEmptyException.class)
                .isThrownBy(out::getRandomQuestion);
    }

    @Test
    void getQuestionsAmountTest() {
        when(questionRepository.getAll()).thenReturn(List.of(QUESTION_OBJECT));

        assertThat(out.getQuestionsAmount()).isEqualTo(questionRepository.getAll().size());
    }

}
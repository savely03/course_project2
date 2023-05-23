package com.savely.courseproject2.service.impl;

import com.savely.courseproject2.exception.ListOfQuestionsIsEmptyException;
import com.savely.courseproject2.exception.QuestionAlreadyAddedException;
import com.savely.courseproject2.exception.QuestionNotFoundException;
import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.service.QuestionService;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static com.savely.courseproject2.constants.QuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.*;

class JavaQuestionServiceTest {

    private final QuestionService out = new JavaQuestionService();

    @Test
    void addTest() {
        int initialSize = out.getAll().size();

        assertThat(out.add(QUESTION, ANSWER)).isEqualTo(QUESTION_OBJECT);
        assertThat(out.getAll()).contains(QUESTION_OBJECT).hasSize(initialSize + 1);
    }

    @Test
    void addWhenQuestionAlreadyAddedTest() {
        out.add(QUESTION, ANSWER);

        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> out.add(QUESTION, ANSWER));
    }

    @Test
    void removeTest() {
        out.add(QUESTION, ANSWER);
        int initialSize = out.getAll().size();

        assertThat(out.remove(QUESTION, ANSWER)).isEqualTo(QUESTION_OBJECT);
        assertThat(out.getAll()).doesNotContain(QUESTION_OBJECT).hasSize(initialSize - 1);

    }

    @Test
    void removeWhenQuestionNotFoundTest() {
        assertThatExceptionOfType(QuestionNotFoundException.class).isThrownBy(
                () -> out.remove(QUESTION, ANSWER)
        );
    }

    @Test
    void getAllTest() {
        out.add(QUESTION, ANSWER);

        assertThat(out.getAll()).hasSize(1).isEqualTo(List.of(QUESTION_OBJECT));
    }

    @Test
    void getRandomQuestionTest() {
        out.add(QUESTION, ANSWER);

        Collection<Question> expected = out.getAll();

        assertThat(out.getRandomQuestion()).isIn(expected).isEqualTo(QUESTION_OBJECT);
    }

    @Test
    void getRandomQuestionWhenListIsEmptyTest() {
        assertThatExceptionOfType(ListOfQuestionsIsEmptyException.class)
                .isThrownBy(out::getRandomQuestion);
    }

}
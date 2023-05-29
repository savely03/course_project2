package com.savely.courseproject2.service.impl;

import com.savely.courseproject2.exception.ListOfQuestionsIsEmptyException;
import com.savely.courseproject2.exception.QuestionAlreadyAddedException;
import com.savely.courseproject2.exception.QuestionNotFoundException;
import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.repository.QuestionRepository;
import com.savely.courseproject2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (questionRepository.contains(newQuestion)) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже существует!");
        }
        return questionRepository.add(newQuestion);
    }

    @Override
    public Question remove(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (!questionRepository.contains(newQuestion)) {
            throw new QuestionNotFoundException("Такого вопроса не существует!");
        }
        return questionRepository.remove(newQuestion);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = (List<Question>) questionRepository.getAll();

        if (questions.size() > 0) {
            return questions.get(random.nextInt(questions.size()));
        }

        throw new ListOfQuestionsIsEmptyException("Список вопросов пуст!");
    }
}

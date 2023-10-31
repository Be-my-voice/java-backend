package com.bemyvoice.bemyvoicebackend.service;

import com.bemyvoice.bemyvoicebackend.dto.QuizDto;
import com.bemyvoice.bemyvoicebackend.entity.Quiz;

import java.util.List;

public interface QuizService {
    QuizDto createQuiz(QuizDto quizDto);

    List<QuizDto> getAllQuizes();

    QuizDto getQuizById(Long quizId);

    void deleteQuiz(Long quizId);

    QuizDto updateQuiz(Long quizId, QuizDto updateQuiz);

    QuizDto disableQuiz(Long quizId);

    QuizDto enableQuiz(Long quizId);
}

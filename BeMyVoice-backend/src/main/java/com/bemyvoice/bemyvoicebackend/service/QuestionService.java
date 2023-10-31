package com.bemyvoice.bemyvoicebackend.service;

import com.bemyvoice.bemyvoicebackend.dto.QuestionDto;
import com.bemyvoice.bemyvoicebackend.dto.QuizDto;

import java.util.List;

public interface QuestionService {
    QuestionDto createQuestion(QuestionDto questionDto);

    QuestionDto getQuestionByQuestionId(Long questionId);

    List<QuestionDto> getQuestionsByQuizId(Long quizId);

    void deleteQuestion(Long questionId);

    QuestionDto updateQuestion(Long questionId, QuestionDto questionDto);

    Integer getQuestionCountByQuizId(Long quizId);
}

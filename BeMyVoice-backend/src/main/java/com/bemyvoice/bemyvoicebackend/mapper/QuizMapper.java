package com.bemyvoice.bemyvoicebackend.mapper;

import com.bemyvoice.bemyvoicebackend.dto.QuizDto;
import com.bemyvoice.bemyvoicebackend.entity.Quiz;

public class QuizMapper {

    public static QuizDto mapToQuizDto(Quiz quiz){
        return new QuizDto(
                quiz.getId(),
                quiz.getQuizName(),
                quiz.getQuizDescription(),
                quiz.getEnabled()
        );
    }

    public static Quiz mapToQuiz(QuizDto quizDto){
        return new Quiz(
                quizDto.getId(),
                quizDto.getQuizName(),
                quizDto.getQuizDescription(),
                quizDto.getEnabled()
        );
    }
}

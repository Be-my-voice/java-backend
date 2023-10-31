package com.bemyvoice.bemyvoicebackend.mapper;

import com.bemyvoice.bemyvoicebackend.dto.QuestionDto;
import com.bemyvoice.bemyvoicebackend.entity.Question;

public class QuestionMapper {
    public static QuestionDto mapToQuestionDto(Question question){
        return new QuestionDto(
                question.getId(),
                question.getQuizId(),
                question.getQuestion(),
                question.getAnswer1(),
                question.getAnswer2(),
                question.getAnswer3(),
                question.getAnswer4(),
                question.getCorrectAnswer()
        );
    }
}

package com.bemyvoice.bemyvoicebackend.service.impl;

import com.bemyvoice.bemyvoicebackend.dto.QuestionDto;
import com.bemyvoice.bemyvoicebackend.entity.Question;
import com.bemyvoice.bemyvoicebackend.mapper.QuestionMapper;
import com.bemyvoice.bemyvoicebackend.respository.QuestionRepository;
import com.bemyvoice.bemyvoicebackend.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question question = QuestionMapper.mapToQuestion(questionDto);
        return QuestionMapper.mapToQuestionDto(questionRepository.save(question));
    }

    @Override
    public QuestionDto getQuestionByQuestionId(Long questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("No Question for provided id: "+questionId));
        return QuestionMapper.mapToQuestionDto(question);
    }

    @Override
    public List<QuestionDto> getQuestionsByQuizId(Long quizId) {
        List<Question> questions = questionRepository.findByQuizId(quizId);
        return questions.stream().map((question) -> QuestionMapper.mapToQuestionDto(question)).collect(Collectors.toList());
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question = questionRepository.findById(questionId)
                        .orElseThrow(() -> new RuntimeException("No Question for provided id: "+questionId));
        questionRepository.deleteById(questionId);
    }

    @Override
    public QuestionDto updateQuestion(Long questionId, QuestionDto questionDto) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("No Question for provided id: "+questionId));
        question.setQuestion(questionDto.getQuestion());
        question.setAnswer1(questionDto.getAnswer1());
        question.setAnswer2(questionDto.getAnswer2());
        question.setAnswer3(questionDto.getAnswer3());
        question.setAnswer4(questionDto.getAnswer4());
        question.setCorrectAnswer(questionDto.getCorrectAnswer());

        return QuestionMapper.mapToQuestionDto(questionRepository.save(question));
    }

    @Override
    public Integer getQuestionCountByQuizId(Long quizId) {
        return questionRepository.countByQuizId(quizId);
    }
}

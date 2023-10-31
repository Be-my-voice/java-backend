package com.bemyvoice.bemyvoicebackend.service.impl;

import com.bemyvoice.bemyvoicebackend.dto.QuizDto;
import com.bemyvoice.bemyvoicebackend.entity.Quiz;
import com.bemyvoice.bemyvoicebackend.mapper.QuizMapper;
import com.bemyvoice.bemyvoicebackend.respository.QuizRepository;
import com.bemyvoice.bemyvoicebackend.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;
    @Override
    public QuizDto createQuiz(QuizDto quizDto) {
        Quiz quiz = QuizMapper.mapToQuiz(quizDto);
        Quiz savedQuiz = quizRepository.save(quiz);

        return QuizMapper.mapToQuizDto(savedQuiz);
    }

    @Override
    public List<QuizDto> getAllQuizes() {
        List<Quiz> quizes = quizRepository.findAll();
        return quizes.stream().map((quiz) -> QuizMapper.mapToQuizDto(quiz)).collect(Collectors.toList());
    }

    @Override
    public QuizDto getQuizById(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("No quiz for provided id ("+quizId+")"));
        return QuizMapper.mapToQuizDto(quiz);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("No quiz for provided id ("+quizId+")"));
        quizRepository.deleteById(quizId);
    }

    @Override
    public QuizDto updateQuiz(Long quizId, QuizDto updatedQuiz) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(()-> new RuntimeException("No quiz for provided id ("+quizId+")"));
        quiz.setQuizName(updatedQuiz.getQuizName());
        quiz.setQuizDescription(updatedQuiz.getQuizDescription());
        Quiz updateQuizObj = quizRepository.save(quiz);
        return QuizMapper.mapToQuizDto(updateQuizObj);
    }

    @Override
    public QuizDto disableQuiz(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("No quiz for provided id ("+quizId+")"));
        quiz.setEnabled(false);
        Quiz updatedQuizObj = quizRepository.save(quiz);
        return QuizMapper.mapToQuizDto(updatedQuizObj);
    }

    @Override
    public QuizDto enableQuiz(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("No quiz for provided id ("+quizId+")"));
        quiz.setEnabled(true);
        Quiz updatedQuizObj = quizRepository.save(quiz);
        return QuizMapper.mapToQuizDto(updatedQuizObj);
    }

    @Override
    public List<QuizDto> getAllEnabledQuizes() {
        List<Quiz> quizes = quizRepository.findByEnabled(true);
        return quizes.stream().map((quiz) -> QuizMapper.mapToQuizDto(quiz)).collect(Collectors.toList());
    }
}

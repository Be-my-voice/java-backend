package com.bemyvoice.bemyvoicebackend.controller;

import com.bemyvoice.bemyvoicebackend.dto.*;
import com.bemyvoice.bemyvoicebackend.entity.*;
import com.bemyvoice.bemyvoicebackend.service.*;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApiController {
    private LessonService lessonService;
    private LessonSectionService lessonSectionService;
    private QuizService quizService;
    private QuestionService questionService;
    private MessageService messageService;

    @PostMapping("/create-lesson")
    public ResponseEntity<LessonDto> createLesson(@RequestBody LessonDto lessonDto){
        LessonDto savedLesson =  lessonService.createLesson(lessonDto);
        return new ResponseEntity<>(savedLesson, HttpStatus.CREATED);
    }

    @PostMapping("/create-lesson-section")
    public ResponseEntity<LessonSectionDto> createLessonSection(@RequestBody LessonSectionDto lessonSectionDto){
        LessonSectionDto savedLesson = lessonSectionService.createLessonSection(lessonSectionDto);
        return new ResponseEntity<>(savedLesson, HttpStatus.CREATED);
    }

    @GetMapping("/get-lesson-by-id/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable("id") Long lessonId){
        LessonDto lessonDto = lessonService.getLessonById(lessonId);
        return ResponseEntity.ok(lessonDto);
    }

    @GetMapping("/get-lesson-section-by-id/{id}")
    public ResponseEntity<LessonSectionDto> getLessonSectionById(@PathVariable("id") Long lessonSectionId){
        LessonSectionDto lessonSectionDto = lessonSectionService.getLessonSectionById(lessonSectionId);
        return ResponseEntity.ok(lessonSectionDto);
    }

    @GetMapping("/get-all-lessons")
    public ResponseEntity<List<LessonDto>> getAllLessons(){
        List<LessonDto> lessons = lessonService.getAllLessons();
        return ResponseEntity.ok(lessons);
    }

    @GetMapping("/get-lesson-sections-by-lesson-id/{id}")
    public ResponseEntity<List<LessonSectionDto>> getAllLessonSectionsByLessonId(@PathVariable("id") Long lessonId){
        List<LessonSectionDto> lessonSections = lessonSectionService.getAllLessonSectionByLessonId(lessonId);
        return ResponseEntity.ok(lessonSections);
    }

    @PutMapping("/update-lesson-title/{id}")
    public ResponseEntity<LessonDto> updateLessonTitle(@PathVariable("id") Long lessonId, @RequestBody LessonDto updatedLesson){
        LessonDto lessonDto = lessonService.updateLesson(lessonId, updatedLesson);
        return ResponseEntity.ok(lessonDto);
    }

    @PutMapping("/update-lesson-section/{id}")
    public ResponseEntity<LessonSectionDto> updateLessonSection(@PathVariable("id") Long lessonSectionId, @RequestBody LessonSectionDto updatedLessonSection){
        LessonSectionDto lessonSectionDto = lessonSectionService.updateLessonSection(lessonSectionId, updatedLessonSection);
        return ResponseEntity.ok(lessonSectionDto);
    }

    @PutMapping("/disable-lesson/{id}")
    public ResponseEntity<LessonDto> disableLesson(@PathVariable("id") Long lessonId){
        LessonDto lessonDto = lessonService.disableLesson(lessonId);
        return ResponseEntity.ok(lessonDto);
    }

    @PutMapping("/enable-lesson/{id}")
    public ResponseEntity<LessonDto> enableLesson(@PathVariable("id") Long lessonId){
        LessonDto lessonDto = lessonService.enableLesson(lessonId);
        return ResponseEntity.ok(lessonDto);
    }

    @DeleteMapping("/delete-lesson/{id}")
    public ResponseEntity<String> deleteLesson(@PathVariable("id") Long lessonId){
        lessonService.deleteLesson(lessonId);
        return ResponseEntity.ok("LESSON DELETED SUCCESSFULLY");
    }

    @DeleteMapping("/delete-lesson-section/{id}")
    public ResponseEntity<String> deleteLessonSection(@PathVariable("id") Long lessonSectionId){
        lessonSectionService.deleteLessonSection(lessonSectionId);
        return ResponseEntity.ok("LESSON SECTION DELETED SUCCESSFULLY");
    }

    @GetMapping("/get-enabled-lessons")
    public ResponseEntity<List<LessonDto>> getAllEnabledLessons(){
        List<LessonDto> lessons = lessonService.getEnabledLessons();
        return ResponseEntity.ok(lessons);
    }

    //for quizzes
    @PostMapping("/quiz/create-quiz")
    public ResponseEntity<QuizDto> createQuiz(@RequestBody QuizDto quizDto){
        QuizDto savedQuiz =  quizService.createQuiz(quizDto);
        return new ResponseEntity<>(savedQuiz, HttpStatus.CREATED);
    }

    @GetMapping("/quiz/get-all-quizes")
    public ResponseEntity<List<QuizDto>> getAllQuizes(){
        List<QuizDto> quizes = quizService.getAllQuizes();
        return ResponseEntity.ok(quizes);
    }

    @GetMapping("/quiz/get-quiz-by-id/{id}")
    public ResponseEntity<QuizDto> getQuizById(@PathVariable("id") Long quizId){
        QuizDto quiz = quizService.getQuizById(quizId);
        return ResponseEntity.ok(quiz);
    }

    @DeleteMapping("/quiz/delete-quiz/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable("id") Long quizId){
        quizService.deleteQuiz(quizId);
        return ResponseEntity.ok("QUIZ DELETED SUCCESSFULLY");
    }

    @PutMapping("/quiz/disable-quiz/{id}")
    public ResponseEntity<QuizDto> disableQuiz(@PathVariable("id") Long quizId){
        QuizDto quizDto = quizService.disableQuiz(quizId);
        return ResponseEntity.ok(quizDto);
    }

    @PutMapping("/quiz/enable-quiz/{id}")
    public ResponseEntity<QuizDto> enableQuiz(@PathVariable("id") Long quizId){
        QuizDto quizDto = quizService.enableQuiz(quizId);
        return ResponseEntity.ok(quizDto);
    }

    @GetMapping("/quiz/get-enabled-quizes")
    public ResponseEntity<List<QuizDto>> getEnabledQuizes(){
        List<QuizDto> quizes = quizService.getAllEnabledQuizes();
        return ResponseEntity.ok(quizes);
    }


    @PutMapping("/quiz/update-quiz/{id}")
    public ResponseEntity<QuizDto> updateQuiz(@PathVariable("id") Long quizId,@RequestBody QuizDto quizDto){
        QuizDto quiz = quizService.updateQuiz(quizId, quizDto);
        return ResponseEntity.ok(quiz);
    }

    //quiz - questions
    @PostMapping("/question/create-question")
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto questionDto){
        QuestionDto question = questionService.createQuestion(questionDto);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping("/question/get-question/{id}")
    public ResponseEntity<QuestionDto> getQuestionByQuestionId(@PathVariable("id") Long questionId){
        QuestionDto question = questionService.getQuestionByQuestionId(questionId);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/question/get-questions-by-quiz-id/{id}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByQuizId(@PathVariable("id") Long quizId){
        List<QuestionDto> questions = questionService.getQuestionsByQuizId(quizId);
        return ResponseEntity.ok(questions);
    }

    @DeleteMapping("/question/delete-question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("id") Long questionId){
        questionService.deleteQuestion(questionId);
        return ResponseEntity.ok("QUESTION DELETED SUCCESSFULLY");
    }

    @PutMapping("/question/update-question/{id}")
    public ResponseEntity<QuestionDto> updateQuestion(@PathVariable("id") Long questionId, @RequestBody QuestionDto questionDto){
        QuestionDto updatedQuestion = questionService.updateQuestion(questionId, questionDto);
        return ResponseEntity.ok(updatedQuestion);
    }

    @GetMapping("/quiz/get-question-count/{id}")
    public ResponseEntity<Integer> getNoOfQuestions(@PathVariable("id") Long quizId){
        return ResponseEntity.ok(questionService.getQuestionCountByQuizId(quizId));
    }

    @PostMapping("/chat/send-message")
    public ResponseEntity<MessageDto> sendMessage(@RequestBody MessageDto messageDto){
        System.out.println("sending msg");
        MessageDto savedMsg = messageService.sendMessage(messageDto);
        return ResponseEntity.ok(savedMsg);
    }

    @GetMapping("/chat/receive/{sender}/{receiver}")
    public ResponseEntity<List<MessageDto>> receiveMessage(@PathVariable("sender") UUID sender, @PathVariable("receiver") UUID receiver){
        List<MessageDto> messages = messageService.receiveMessage(sender, receiver);
        return ResponseEntity.ok(messages);
    }
}
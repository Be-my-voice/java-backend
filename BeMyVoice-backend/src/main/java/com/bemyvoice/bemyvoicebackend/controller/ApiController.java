package com.bemyvoice.bemyvoicebackend.controller;

import com.bemyvoice.bemyvoicebackend.dto.LessonDto;
import com.bemyvoice.bemyvoicebackend.dto.LessonSectionDto;
import com.bemyvoice.bemyvoicebackend.entity.Lesson;
import com.bemyvoice.bemyvoicebackend.entity.LessonSection;
import com.bemyvoice.bemyvoicebackend.service.LessonSectionService;
import com.bemyvoice.bemyvoicebackend.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
    private LessonService lessonService;
    private LessonSectionService lessonSectionService;

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
}
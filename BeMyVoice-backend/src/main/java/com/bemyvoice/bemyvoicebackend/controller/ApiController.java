package com.bemyvoice.bemyvoicebackend.controller;

import com.bemyvoice.bemyvoicebackend.dto.LessonDto;
import com.bemyvoice.bemyvoicebackend.dto.LessonSectionDto;
import com.bemyvoice.bemyvoicebackend.entity.Lesson;
import com.bemyvoice.bemyvoicebackend.entity.LessonSection;
import com.bemyvoice.bemyvoicebackend.service.LessonSectionService;
import com.bemyvoice.bemyvoicebackend.service.LessonService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
}

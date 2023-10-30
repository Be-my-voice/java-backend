package com.bemyvoice.bemyvoicebackend.service;

import com.bemyvoice.bemyvoicebackend.dto.LessonDto;
import com.bemyvoice.bemyvoicebackend.entity.Lesson;

import java.util.List;

public interface LessonService {
    LessonDto createLesson(LessonDto lessonDto);

    LessonDto getLessonById(Long lessonId);

    List<LessonDto> getAllLessons();

    LessonDto updateLesson(Long lessonId, LessonDto updatedLesson);

    LessonDto disableLesson(Long lessonId);

    LessonDto enableLesson(Long lessonId);

    void deleteLesson(Long lessonId);

    List<LessonDto> getEnabledLessons();
}

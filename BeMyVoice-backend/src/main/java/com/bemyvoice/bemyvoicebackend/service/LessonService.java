package com.bemyvoice.bemyvoicebackend.service;

import com.bemyvoice.bemyvoicebackend.dto.LessonDto;

import java.util.List;

public interface LessonService {
    LessonDto createLesson(LessonDto lessonDto);

    LessonDto getLessonById(Long lessonId);

    List<LessonDto> getAllLessons();
}

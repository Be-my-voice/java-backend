package com.bemyvoice.bemyvoicebackend.service;

import com.bemyvoice.bemyvoicebackend.dto.LessonSectionDto;

import java.util.List;

public interface LessonSectionService {
    LessonSectionDto createLessonSection(LessonSectionDto lessonSectionDto);

    LessonSectionDto getLessonSectionById(Long lessonSectionId);

    List<LessonSectionDto> getAllLessonSectionByLessonId();
}

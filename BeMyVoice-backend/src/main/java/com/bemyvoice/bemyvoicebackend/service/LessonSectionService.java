package com.bemyvoice.bemyvoicebackend.service;

import com.bemyvoice.bemyvoicebackend.dto.LessonSectionDto;
import com.bemyvoice.bemyvoicebackend.entity.Lesson;
import com.bemyvoice.bemyvoicebackend.entity.LessonSection;

import java.util.List;

public interface LessonSectionService {
    LessonSectionDto createLessonSection(LessonSectionDto lessonSectionDto);

    LessonSectionDto getLessonSectionById(Long lessonSectionId);

    List<LessonSectionDto> getAllLessonSectionByLessonId(Long lesson_id);

    LessonSectionDto updateLessonSection(long lessonSectionId, LessonSectionDto updatedLessonSection);

    void deleteLessonSection(Long lessonSectionId);
}

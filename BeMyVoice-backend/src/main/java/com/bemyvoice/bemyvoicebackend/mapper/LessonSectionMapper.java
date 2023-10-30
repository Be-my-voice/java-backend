package com.bemyvoice.bemyvoicebackend.mapper;

import com.bemyvoice.bemyvoicebackend.dto.LessonSectionDto;
import com.bemyvoice.bemyvoicebackend.entity.LessonSection;

public class LessonSectionMapper {
    public static LessonSectionDto mapToLessonSectionDto(LessonSection lessonSection){
        return new LessonSectionDto(
                lessonSection.getId(),
                lessonSection.getLessonId(),
                lessonSection.getSectionName(),
                lessonSection.getSectionDescription(),
                lessonSection.getVideo()
        );
    }

    public static LessonSection mapToLessonSection(LessonSectionDto lessonSectionDto){
        return new LessonSection(
                lessonSectionDto.getId(),
                lessonSectionDto.getLessonId(),
                lessonSectionDto.getSectionName(),
                lessonSectionDto.getSectionDescription(),
                lessonSectionDto.getVideo()
        );
    }
}

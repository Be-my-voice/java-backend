package com.bemyvoice.bemyvoicebackend.mapper;

import com.bemyvoice.bemyvoicebackend.dto.LessonSectionDto;
import com.bemyvoice.bemyvoicebackend.entity.LessonSection;

public class LessonSectionMapper {
    public static LessonSectionDto mapToLessonSectionDto(LessonSection lessonSection){
        return new LessonSectionDto(
                lessonSection.getId(),
                lessonSection.getLesson_id(),
                lessonSection.getSection_name(),
                lessonSection.getSection_description(),
                lessonSection.getVideo()
        );
    }

    public static LessonSection mapToLessonSection(LessonSectionDto lessonSectionDto){
        return new LessonSection(
                lessonSectionDto.getId(),
                lessonSectionDto.getLesson_id(),
                lessonSectionDto.getSection_name(),
                lessonSectionDto.getSection_description(),
                lessonSectionDto.getVideo()
        );
    }
}

package com.bemyvoice.bemyvoicebackend.mapper;

import com.bemyvoice.bemyvoicebackend.dto.LessonDto;
import com.bemyvoice.bemyvoicebackend.entity.Lesson;

public class LessonMapper {

    public static LessonDto mapToLessonDto(Lesson lesson){
        return new LessonDto(
                lesson.getId(),
                lesson.getTitle()
        );
    }

    public static Lesson mapToLesson(LessonDto lessonDto){
        return new Lesson(
                lessonDto.getId(),
                lessonDto.getTitle()
        );
    }
}

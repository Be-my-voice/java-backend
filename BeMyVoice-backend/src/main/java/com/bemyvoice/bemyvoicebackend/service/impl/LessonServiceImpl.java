package com.bemyvoice.bemyvoicebackend.service.impl;

import com.bemyvoice.bemyvoicebackend.dto.LessonDto;
import com.bemyvoice.bemyvoicebackend.entity.Lesson;
import com.bemyvoice.bemyvoicebackend.entity.LessonSection;
import com.bemyvoice.bemyvoicebackend.exception.ResourceNotFoundException;
import com.bemyvoice.bemyvoicebackend.mapper.LessonMapper;
import com.bemyvoice.bemyvoicebackend.mapper.LessonSectionMapper;
import com.bemyvoice.bemyvoicebackend.respository.LessonRepository;
import com.bemyvoice.bemyvoicebackend.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LessonServiceImpl implements LessonService {
    private LessonRepository lessonRepository;

    @Override
    public LessonDto createLesson(LessonDto lessonDto) {
        Lesson lesson = LessonMapper.mapToLesson(lessonDto);
        Lesson savedLesson = lessonRepository.save(lesson);

        return LessonMapper.mapToLessonDto(savedLesson);
    }

    @Override
    public LessonDto getLessonById(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(()-> new RuntimeException("No lesson for provided id ("+lessonId+")"));
        return LessonMapper.mapToLessonDto(lesson);
    }

    @Override
    public List<LessonDto> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessons.stream().map((lesson) -> LessonMapper.mapToLessonDto(lesson)).collect(Collectors.toList());
    }

    @Override
    public LessonDto updateLesson(Long lessonId, LessonDto updatedLesson) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() -> new ResourceNotFoundException("No lesson for given id :"+lessonId));
        lesson.setTitle(updatedLesson.getTitle());
        Lesson updatedLessonObj = lessonRepository.save(lesson);
        return LessonMapper.mapToLessonDto(updatedLessonObj);
    }

    @Override
    public LessonDto disableLesson(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() -> new RuntimeException("No lesson for given id :"+lessonId));
        lesson.setEnabled(false);
        Lesson updatedLessonObj = lessonRepository.save(lesson);
        return LessonMapper.mapToLessonDto(updatedLessonObj);
    }

    @Override
    public LessonDto enableLesson(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() -> new RuntimeException("No lesson for given id :"+lessonId));
        lesson.setEnabled(true);
        Lesson updatedLessonObj = lessonRepository.save(lesson);
        return LessonMapper.mapToLessonDto(updatedLessonObj);
    }

    @Override
    public void deleteLesson(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() -> new ResourceNotFoundException("No lesson for given id :"+lessonId));
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public List<LessonDto> getEnabledLessons() {
        List<Lesson> lessons = lessonRepository.findByEnabled(true);
        return lessons.stream().map((lesson) -> LessonMapper.mapToLessonDto(lesson)).collect(Collectors.toList());
    }
}

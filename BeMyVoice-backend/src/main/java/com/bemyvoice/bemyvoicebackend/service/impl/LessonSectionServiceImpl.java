package com.bemyvoice.bemyvoicebackend.service.impl;

import com.bemyvoice.bemyvoicebackend.dto.LessonSectionDto;
import com.bemyvoice.bemyvoicebackend.entity.LessonSection;
import com.bemyvoice.bemyvoicebackend.exception.ResourceNotFoundException;
import com.bemyvoice.bemyvoicebackend.mapper.LessonSectionMapper;
import com.bemyvoice.bemyvoicebackend.respository.LessonSectionRepository;
import com.bemyvoice.bemyvoicebackend.service.LessonSectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LessonSectionServiceImpl implements LessonSectionService {

    private LessonSectionRepository lessonSectionRepository;

    @Override
    public LessonSectionDto createLessonSection(LessonSectionDto lessonSectionDto) {
        LessonSection lessonSection = LessonSectionMapper.mapToLessonSection(lessonSectionDto);
        LessonSection savedLessonSection = lessonSectionRepository.save(lessonSection);
        return LessonSectionMapper.mapToLessonSectionDto(savedLessonSection);
    }

    @Override
    public LessonSectionDto getLessonSectionById(Long lessonSectionId) {
        LessonSection lessonSection = lessonSectionRepository.findById(lessonSectionId)
                .orElseThrow(()-> new RuntimeException("No lesson section for provided id ("+lessonSectionId+")"));
        return LessonSectionMapper.mapToLessonSectionDto(lessonSection);
    }

    @Override
    public List<LessonSectionDto> getAllLessonSectionByLessonId(Long lesson_id) {
        List<LessonSection> lessonSections = lessonSectionRepository.findByLessonId(lesson_id);
        return lessonSections.stream().map((lessonSection) -> LessonSectionMapper.mapToLessonSectionDto(lessonSection)).collect(Collectors.toList());
    }

    @Override
    public LessonSectionDto updateLessonSection(long lessonSectionId, LessonSectionDto updatedLessonSection) {
        LessonSection lessonSection = lessonSectionRepository.findById(lessonSectionId).orElseThrow(() -> new ResourceNotFoundException("No lesson section for given id :"+lessonSectionId));

        lessonSection.setSectionName(updatedLessonSection.getSectionName());
        lessonSection.setSectionDescription(updatedLessonSection.getSectionDescription());
        lessonSection.setVideo(updatedLessonSection.getVideo());

        LessonSection updatedLessonSectionObj = lessonSectionRepository.save(lessonSection);
        return LessonSectionMapper.mapToLessonSectionDto(updatedLessonSectionObj);
    }

    @Override
    public void deleteLessonSection(Long lessonSectionId) {
        LessonSection lessonSection = lessonSectionRepository.findById(lessonSectionId).orElseThrow(() -> new ResourceNotFoundException("No lesson for given id :"+lessonSectionId));
        lessonSectionRepository.deleteById(lessonSectionId);
    }
}

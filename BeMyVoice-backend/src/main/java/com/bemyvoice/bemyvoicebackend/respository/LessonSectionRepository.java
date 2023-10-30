package com.bemyvoice.bemyvoicebackend.respository;

import com.bemyvoice.bemyvoicebackend.entity.LessonSection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonSectionRepository extends JpaRepository<LessonSection, Long> {

    List<LessonSection> findByLessonId(Long lessonId);
}

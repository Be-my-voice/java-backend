package com.bemyvoice.bemyvoicebackend.respository;

import com.bemyvoice.bemyvoicebackend.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByEnabled(boolean b);
}

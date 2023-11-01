package com.bemyvoice.bemyvoicebackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LessonSections")
public class LessonSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lesson_id", nullable = false)
    private Long lessonId;

    @Column(name = "section_name" ,nullable = false)
    private String sectionName;

    @Column(name = "section_description")
    private String sectionDescription;

    @Column(name = "video", columnDefinition = "LONGTEXT")
    private String video;
}

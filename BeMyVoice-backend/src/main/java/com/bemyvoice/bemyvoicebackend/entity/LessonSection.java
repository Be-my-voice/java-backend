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
    private Long lesson_id;

    @Column(name = "section_name" ,nullable = false)
    private String section_name;

    @Column(name = "section_description")
    private String section_description;

    @Column(name = "video")
    @Lob
    private String video;
}

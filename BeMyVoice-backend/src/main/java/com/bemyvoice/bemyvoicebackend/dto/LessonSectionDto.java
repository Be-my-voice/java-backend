package com.bemyvoice.bemyvoicebackend.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LessonSectionDto {
    private Long id;
    private Long lessonId;
    private String sectionName;

    private String sectionDescription;

    @Lob
    private String video;
}

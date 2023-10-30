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
    private Long lesson_id;
    private String section_name;

    private String section_description;

    @Lob
    private String video;
}

package com.bemyvoice.bemyvoicebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizDto {
    private Long id;
    private String quizName;
    private String quizDescription;
    private Boolean enabled;
}

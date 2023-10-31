package com.bemyvoice.bemyvoicebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Quizes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quiz_name")
    private String quizName;

    @Column(name = "quiz_description")
    private String quizDescription;

    @Column(name = "enabled")
    private Boolean enabled;
}

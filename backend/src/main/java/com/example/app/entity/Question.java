package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crtOption;
    @ElementCollection
    @CollectionTable(name = "options", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option")
    private List<String> options;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizId")
    @JsonIgnore
    private Quiz quiz;
}


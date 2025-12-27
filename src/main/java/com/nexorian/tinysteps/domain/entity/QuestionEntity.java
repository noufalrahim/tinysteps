package com.nexorian.tinysteps.domain.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
public class QuestionEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "question_en", nullable = false)
    private String questionEnglish;

    @Column(name = "question_mal", columnDefinition = "TEXT")
    private String questionMalayalam;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer severity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "agegroup_id", nullable = false)
    private AgeGroupEntity ageGroup;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private String image;

}

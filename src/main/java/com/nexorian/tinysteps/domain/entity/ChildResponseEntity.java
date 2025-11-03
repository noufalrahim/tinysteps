package com.nexorian.tinysteps.domain.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "child_response")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChildResponseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name="question_id", referencedColumnName = "id", nullable=false)
    private QuestionEntity question;

    @Column(nullable=false)
    private Boolean questionAnswered;

    @Column
    private Boolean answeredYes;

    @ManyToOne
    @JoinColumn(name="child_id", referencedColumnName = "id", nullable = false)
    private ChildEntity child;

    private Date achievedOn;
}


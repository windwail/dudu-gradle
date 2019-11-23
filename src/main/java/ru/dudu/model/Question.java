package ru.dudu.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Question extends BaseEntity {

    enum QuestionType {GENERATED, STATIC}

    @Column
    @Enumerated(EnumType.STRING)
    QuestionType type;

    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    String data;

    @OneToMany
    Set<Answer> possibleAnswers;

    @OneToMany
    Set<Answer> correctAnswers;

    @Column
    Integer numCorrectAnswers;

}

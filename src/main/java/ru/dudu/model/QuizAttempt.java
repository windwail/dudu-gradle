package ru.dudu.model;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

//@Entity
public class QuizAttempt  extends BaseEntity{
    @OneToOne
    Quiz quiz;

    @OneToMany(targetEntity = QuizConfig.class)
    Set<QuizConfig> config;

    @OneToOne
    UserAccaunt user;

    @OneToMany(targetEntity = Question.class)
    List<Question> questions;

}

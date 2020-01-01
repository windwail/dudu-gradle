package ru.dudu.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Quiz extends BaseEntity {

    @Column
    @NotNull
    String name;

    @Column
    @NotNull
    String description;

    @OneToMany(mappedBy = "quiz")
    Set<QuizSettings> settings;

    @OneToMany
    Set<Question> questionPool;

    @Column
    Long version;

}

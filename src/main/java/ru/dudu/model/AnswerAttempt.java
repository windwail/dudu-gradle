package ru.dudu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class AnswerAttempt extends BaseEntity{

    @OneToMany
    Set<Answer> answers;

    @Column
    String answer;

}

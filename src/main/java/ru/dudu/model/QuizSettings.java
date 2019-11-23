package ru.dudu.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class QuizSettings extends BaseEntity {

    @Column
    String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    String settings;

    @ManyToOne
    Quiz quiz;

    @Column
    Long version;


}

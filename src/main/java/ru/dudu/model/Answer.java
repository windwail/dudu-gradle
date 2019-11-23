package ru.dudu.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Answer extends BaseEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    String data;

}

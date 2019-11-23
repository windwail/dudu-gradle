package ru.dudu.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Data
public class Word  extends BaseEntity {

    @Column(unique = true)
    @NotNull
    String word;

    @Column
    Integer frequency;

    public Word(@NotNull String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}

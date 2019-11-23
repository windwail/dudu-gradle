package ru.dudu.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class QuizConfig extends BaseEntity{

    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    String aggregatedConfig;

    @OneToOne
    QuizSettings settings;

    @OneToOne
    UserAccaunt user;

}

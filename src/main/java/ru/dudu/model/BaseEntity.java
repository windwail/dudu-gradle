package ru.dudu.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
        //https://vladmihalcea.com/how-to-map-json-objects-using-generic-hibernate-types/
})
@Data
public class BaseEntity {
/*    @Id @Type(type = "pg-uuid")
    private UUID id;

    public BaseEntity() {
        this.id = UUID.randomUUID();
    }*/

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;



}
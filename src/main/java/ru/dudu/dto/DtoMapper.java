package ru.dudu.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.dudu.model.Quiz;

@Mapper
public interface DtoMapper {

    DtoMapper MAPPER = Mappers.getMapper( DtoMapper.class );;

    SimpleQuiz simpleQuizFromQuiz(Quiz q);
}

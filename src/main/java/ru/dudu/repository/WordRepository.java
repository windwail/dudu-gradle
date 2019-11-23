package ru.dudu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dudu.model.Word;

import java.util.List;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
    List<Word> findAll();

    //select word from word where word ~ '^[д]+.*';
    //[^нлкгбхцтзчрпшщжсмвфд]
    //select word from word where word ~ '^[д]+[^нлкгбхцтзчрпшщжсмвфд]*[см]+[^нлкгбхцтзчрпшщжсмвфд]*[вф]+[^нлкгбхцтзчрпшщжсмвфд]*';

    //@Query(value = "select * from word where word ~ '^:pat'", nativeQuery = true)
    //List<Word> optionalRegex(@Param("pat")String pattern);



}

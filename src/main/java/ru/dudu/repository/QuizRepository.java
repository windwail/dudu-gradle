package ru.dudu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dudu.model.Quiz;

import java.util.List;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

    List<Quiz> findAll();
}

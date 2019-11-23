package ru.dudu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dudu.model.QuizConfig;

@Repository
public interface QuizConfigRepository extends CrudRepository<QuizConfig, Long> {
}

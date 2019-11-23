package ru.dudu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dudu.model.QuizSettings;

@Repository
public interface QuizSettingsRepository extends CrudRepository<QuizSettings, Long> {
}

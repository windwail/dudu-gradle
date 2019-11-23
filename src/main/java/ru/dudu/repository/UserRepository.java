package ru.dudu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dudu.model.UserAccaunt;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserAccaunt, Long> {

    Optional<UserAccaunt> findByLogin(String login);

}


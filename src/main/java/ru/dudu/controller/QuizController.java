package ru.dudu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dudu.model.Quiz;
import ru.dudu.model.UserAccaunt;
import ru.dudu.repository.QuizRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class QuizController {

    @Autowired
    QuizRepository quizRepo;

    @GetMapping("/quiz/list")
    public ResponseEntity login() {
        return ResponseEntity.ok(quizRepo.findAll().stream().map( q -> q.getId()).collect(Collectors.toList()));
    }

}

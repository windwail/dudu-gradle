package ru.dudu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dudu.dto.DtoMapper;
import ru.dudu.repository.QuizRepository;

import java.util.stream.Collectors;

import static ru.dudu.dto.DtoMapper.MAPPER;

@RestController
public class QuizController {

    @Autowired
    QuizRepository quizRepo;

    @GetMapping("/quiz/list")
    public ResponseEntity login() {
        return ResponseEntity.ok(
                quizRepo.findAll().stream()
                        .map(MAPPER::simpleQuizFromQuiz)
                        .collect(Collectors.toList()));
    }

}

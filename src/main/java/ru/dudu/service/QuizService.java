package ru.dudu.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.dudu.model.*;
import ru.dudu.repository.QuizConfigRepository;
import ru.dudu.repository.QuizRepository;
import ru.dudu.repository.QuizSettingsRepository;

import java.io.File;
import java.nio.file.Files;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizSettingsRepository quizSettingsRepo;

    @Autowired
    private QuizRepository quizRepo;

    @Autowired
    private QuizConfigRepository quizConfigRepo;

    /**
     * Подготовка классов для теста по 100 числам.
     * @return
     */
    public Long prepareNumberQuiz() throws Exception {
        Quiz quiz =  new Quiz();

        Quiz q = new Quiz();
        q.setName("numbers_quiz");
        quizRepo.save(q);

        QuizSettings settings = new QuizSettings();
        settings.setName("numbers_associations");
        settings.setQuiz(q);

        JSONArray set = new JSONArray();
        for(int i=0; i< 100; i++) {
            set.put(new JSONObject("{\""+i+"\":\"string\"}"));
        }

        settings.setSettings(set.toString());
        quizSettingsRepo.save(settings);

        QuizConfig config = new QuizConfig();

        File file = new ClassPathResource("/numbers.json").getFile();
        String content = new String(Files.readAllBytes(file.toPath()));
        JSONArray ass = new JSONArray(content);
        config.setAggregatedConfig(ass.toString());
        config.setSettings(settings);
        quizConfigRepo.save(config);


        if(true) return 1l;

        for(Object o: ass) {
            JSONObject obj = (JSONObject) o;
            System.out.println(obj);
        }

        return 0l;
    }

}

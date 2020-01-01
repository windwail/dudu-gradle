package ru.dudu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.dudu.model.Quiz;
import ru.dudu.model.QuizSettings;
import ru.dudu.repository.QuizRepository;
import ru.dudu.repository.QuizSettingsRepository;
import ru.dudu.service.QuizService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DuduApplication.class)
public class TestDb {

    @Autowired
    private QuizService quizService;

    @Test
    public void doTest() throws Exception {

        quizService.prepareNumberQuiz();

    }


}

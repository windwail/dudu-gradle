package ru.dudu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dudu.dto.NumberRequest;
import ru.dudu.model.Word;
import ru.dudu.repository.WordRepository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class WordController {
    Logger log = LoggerFactory.getLogger(WordController.class);

    @Autowired
    private WordRepository wordRepository;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/words")
    public List<Word> getWordsForNumber(@RequestBody NumberRequest numReq) throws Exception{
        String num = numReq.getNum().toString();

        String anySymbol = "[^нлкгбхцтзчрпшщжсмвфд]*";

        HashMap<Integer, String> numberCodes = new HashMap<>();
        numberCodes.put(0, "нл");
        numberCodes.put(1, "кг");
        numberCodes.put(2, "бхц");
        numberCodes.put(3, "тз");
        numberCodes.put(4, "чр");
        numberCodes.put(5, "п");
        numberCodes.put(6, "шщж");
        numberCodes.put(7, "см");
        numberCodes.put(8, "вф");
        numberCodes.put(9, "д");

        StringBuffer sb = new StringBuffer();

        sb.append(anySymbol);
        for(Character n : num.toCharArray()) {
            Integer posNum = Integer.parseInt(n.toString());
            sb.append("["+numberCodes.get(posNum)+"]+");
            sb.append(anySymbol);
        }

        log.error(sb.toString());

        String query = "select word, frequency from word where word ~ '^" + sb.toString() + "' order by frequency desc";

        DataSource ds = jdbcTemplate.getDataSource();
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs =  ps.executeQuery();

        List<Word> resutl = new ArrayList<>();
        while(rs.next()){
            resutl.add(new Word(rs.getString(1), rs.getInt(2)));
        }

        return resutl;
    }


    @GetMapping("/import")
    @Transactional
    public List<Word> getAllWords() throws Exception {
        List<Word> list = wordRepository.findAll();

        if(list.isEmpty()) {
            fill("litf-win.txt", "insert into word (word, frequency) values(?,?)", wordRepository);
            list = wordRepository.findAll();
        }

        return list;
    }

    // "insert into word (word) values(?)"
    // "word_rus.txt"
    // "insert into noun (word) values(?)"
    // "zdb-win.txt"
    // fill("zdb-win.txt", "insert into noun (word) values(?)", nounRepository);
    synchronized private void fill(String file, String query, CrudRepository repo) {
        try {

            // Fix cuncurrent invocation;
            if(repo.findAll().iterator().hasNext()) {
                return;
            }

            ClassPathResource resource = new ClassPathResource(file);
            DataSource ds = jdbcTemplate.getDataSource();
            Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            AtomicInteger count = new AtomicInteger();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                reader.lines().forEach(s -> {
                    try {
                        String[] split = s.split("\\s+");

                        ps.setString(1, split[0]);
                        ps.setInt(2, Integer.valueOf(split[1]));
                        ps.addBatch();
                        int i = count.incrementAndGet();

                        if (i > 1000) {
                            log.error("Batch!");
                            count.set(0);
                            ps.executeBatch();
                            ps.clearBatch();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
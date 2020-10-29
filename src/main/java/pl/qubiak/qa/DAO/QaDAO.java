package pl.qubiak.qa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.Model.QaModel;

import java.util.List;
import java.util.Map;

@Repository
public class QaDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveQuestion(QaModel qa) {
        String sql = "INSERT INTO qa VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{
            qa.getId(),
            qa.getQuestion()
        });
    }

    public void saveAnswer(QaModel qa) {
        String sql = "INSERT INTO qa VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{
                qa.getId(),
                qa.getAnswer()
        });
    }

    public void saveCounter(QaModel qa){
        String sql = "INSERT INTO qa VALUES ?";
        jdbcTemplate.update(sql, new Object[]{
                qa.getCounter()
        });
    }

    public List<Map<String, Object>> showById(int id){
        String sql = "SELECT * FROM qa WHERE id LIKE ?";
        return jdbcTemplate.queryForList(sql, new Object[]{id});
    }

    public List<Map<String, Object>> showEverything() {
        String sql = "SELECT * FROM qa";
        return jdbcTemplate.queryForList(sql, new Object[]{});
    }


    @Bean
    public void dbInit() {
        String sql = "CREATE TABELE qa(question_id int, question varchar(255), answer varchar(255), like_counter int);";


    }
}

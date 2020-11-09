package pl.qubiak.qa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.Model.Answer;
import pl.qubiak.qa.RowMapper.AnswerRowMapper;
import java.util.List;

@Repository
public class AnswerDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AnswerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAnswer(int questionId, String answer) {
        String sql = "INSERT INTO qaanswer (questionId, answer) VALUES (?, ?);";
        jdbcTemplate.update(sql, new Object[]{answer, questionId});
    }

    public List<Answer> showEverythingFromAnswer() {
        String sql = "SELECT * FROM qaanswer";
        List<Answer> answers = jdbcTemplate.query(sql, new AnswerRowMapper());
        return answers;
    }

}

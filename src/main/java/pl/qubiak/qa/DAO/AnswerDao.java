package pl.qubiak.qa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.Model.Answer;
import pl.qubiak.qa.RowMapper.AnswerRowMapper;
import java.util.List;

@Repository
public class AnswerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AnswerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAnswer(int questionId, String answer) {
        String sql = "INSERT INTO answertable (questionId, answer) VALUES (?, ?);";
        jdbcTemplate.update(sql, new Object[]{questionId, answer});
    }

    public List<Answer> showEverythingFromAnswer() {
        String sql = "SELECT * FROM answertable";
        List<Answer> answers = jdbcTemplate.query(sql, new AnswerRowMapper());
        return answers;
    }

    public List<Answer> showAnswerByQuestionId(int questionId) {
        String sql = "SELECT * FROM answertable WHERE questionId = ?";
        List<Answer> answers = jdbcTemplate.query(sql, new Object[]{questionId}, new AnswerRowMapper());
        return answers;
    }

    public void editAnswer(int id, String answer) {
        String sql = "UPDATE `answertable` SET `answer` = ? WHERE `answertable`.`id` = ?";
        jdbcTemplate.update(sql, answer, id);
    }
}

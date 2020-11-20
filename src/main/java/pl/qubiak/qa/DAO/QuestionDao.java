package pl.qubiak.qa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.Model.Question;
import pl.qubiak.qa.RowMapper.QuestionRowMapper;

import java.util.List;
import java.util.Map;

@Repository
public class QuestionDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveQuestion(String question, int roomId) {
        String sql = "INSERT INTO question (question, like_counter) VALUES (?, 0);";
        jdbcTemplate.update(sql, new Object[]{question, roomId});
    }

    public List<Map<String, Object>> showById(int id) {
        String sql = "SELECT * FROM question WHERE id = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{id});
    }

    public List<Map<String, Object>> showByRoomId(int roomId) {
        String sql = "SELECT * FROM question WHERE roomId =?";
        return jdbcTemplate.queryForList(sql, new Object[]{roomId});
    }


    public List<Question> showEverything() {
        String sql = "SELECT * FROM question";
        List<Question> questions = jdbcTemplate.query(sql, new QuestionRowMapper());
        return questions;
    }

    public void delateByID(int id) {
        String sql = "DELETE FROM `question` WHERE `question`.`id` = ?;";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public void delateAll() {
        String sql = "DELATE * FROM question";
        jdbcTemplate.update(sql, new Object[]{});
    }

    public int readAcctuallyLiktCounter(int id) {
        String sql = "SELECT * FROM question WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new QuestionRowMapper()).getLike_counter();
    }

    public void saveLikeCounter(int id) {
        String sql = "UPDATE question SET like_counter = like_counter + 1 where ID = ?";
        jdbcTemplate.update(sql, id);
    }

    public void saveDissLikeCounter(int id) {
        String sql = "UPDATE question SET like_counter = like_counter - 1 where ID = ?";
        jdbcTemplate.update(sql, id);
    }
}

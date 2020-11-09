package pl.qubiak.qa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.Model.Question;
import pl.qubiak.qa.RowMapper.QuestionRowMapper;
import java.util.List;
import java.util.Map;

@Repository
public class QuestionDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveQuestion(String question) {
        String sql = "INSERT INTO qa (question, like_counter) VALUES (?, 0);";
        jdbcTemplate.update(sql, new Object[]{question});
    }

    public List<Map<String, Object>> showById(int id) {
        String sql = "SELECT * FROM qa WHERE id = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{id});
    }

    public List<Question> showEverything() {
        String sql = "SELECT * FROM qa";
        List<Question> questions = jdbcTemplate.query(sql, new QuestionRowMapper());
        return questions;
    }


    public List<Map<String, Object>> showIdAndQuestion() {
        String sql = "SELECT CONCAT(id, '. ', question) FROM qa";
        return jdbcTemplate.queryForList(sql, new Object[]{});
    }


    public void delateByID(int id) {
        String sql = "DELETE FROM `qa` WHERE `qa`.`id` = ?;";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public int readAcctuallyLiktCounter(int id) {
        String sql = "SELECT * FROM qa WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new QuestionRowMapper()).getCounter();
    }

    public void saveLikeCounter(int id) {
        String sql = "UPDATE qa SET like_counter = like_counter + 1 where ID = ?";
        jdbcTemplate.update(sql, id);
    }

    public void saveDissLikeCounter(int id) {
        String sql = "UPDATE qa SET like_counter = like_counter - 1 where ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
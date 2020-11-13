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

    public void saveQuestion(String question) {
        String sql = "INSERT INTO questiontable (question, like_counter) VALUES (?, 0);";
        jdbcTemplate.update(sql, new Object[]{question});
    }

    public List<Map<String, Object>> showById(int id) {
        String sql = "SELECT * FROM questiontable WHERE id = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{id});
    }


    public List<Question> showEverything() {
        String sql = "SELECT * FROM questiontable";
        List<Question> questions = jdbcTemplate.query(sql, new QuestionRowMapper());
        return questions;
    }


    public List<Map<String, Object>> showIdAndQuestion() {
        String sql = "SELECT CONCAT(id, '. ', question) FROM questiontable";
        return jdbcTemplate.queryForList(sql, new Object[]{});
    }


    public void delateByID(int id) {
        String sql = "DELETE FROM `questiontable` WHERE `questiontable`.`id` = ?;";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public void delateAll() {
        String sql = "DELATE * FROM questiontable";
        jdbcTemplate.update(sql, new Object[]{});
    }

    public int readAcctuallyLiktCounter(int id) {
        String sql = "SELECT * FROM questiontable WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new QuestionRowMapper()).getLike_counter();
    }

    public void saveLikeCounter(int id) {
        String sql = "UPDATE questiontable SET like_counter = like_counter + 1 where ID = ?";
        jdbcTemplate.update(sql, id);
    }

    public void saveDissLikeCounter(int id) {
        String sql = "UPDATE questiontable SET like_counter = like_counter - 1 where ID = ?";
        jdbcTemplate.update(sql, id);
    }
}

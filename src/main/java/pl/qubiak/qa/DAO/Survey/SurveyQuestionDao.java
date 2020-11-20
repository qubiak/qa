package pl.qubiak.qa.DAO.Survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SurveyQuestionDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SurveyQuestionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveSurveyQuestion(String surveyQuestion) {
        String sql = "INSERT INTO surveqquestion (question) VALUES (?)";
        jdbcTemplate.update(sql, new Object[]{surveyQuestion});
    }

    public void editSurveyQuestion(int id, String surveyQuestion) {
        String sql = "UPDATE surveyQuestion SET surveyQuestion = ? WHERE surveyQuestion.id = ?";
        jdbcTemplate.update(sql, surveyQuestion, id);
    }

    public void delateSurvayQuestionById(int id) {
        String sql = "DELETE FROM `surveyQuestion` WHERE `surveyQuestion`.`id` = ?;";
        jdbcTemplate.update(sql, new Object[]{id});
    }
}
package pl.qubiak.qa.DAO.Survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.RowMapper.SurveyMapper.SurveyAnswerRowMapper;

@Repository
public class SurveyAnswerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SurveyAnswerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addSurvayAnswer(int surveyQuestionId, String surveyAnswer) {
        String sql ="INSERT INTO surveyanswer (surveyQuestionId, surveyAnswer, numberOfSelections) VALUES (?, ?, 0);";
        jdbcTemplate.update(sql, new Object[]{surveyQuestionId, surveyAnswer});
    }

    public void delateSurveyAnswerByID(int id) {
        String sql = "DELETE FROM `surveyAnswer` WHERE `surveyQuestion`.`id` = ?;";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public void editSurveyAnswer(int id, String surveyQuestion) {
        String sql = "UPDATE surveyAnswer SET surveyAnswer = ? WHERE surveyAnswer.id = ?";
        jdbcTemplate.update(sql, surveyQuestion, id);
    }

    public int readAcctuallyNumberOfSelections(int id) {
        String sql = "SELECT * FROM surveyAnswer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new SurveyAnswerRowMapper()).getNumberOfSelections();
    }

    public void voteSurveyAnswer(int id) {
        String sql = "UPDATE surveyAnswer SET numberOfSelections = numberOfSelections + 1 where ID = ?";
        jdbcTemplate.update(sql, id);
    }
}

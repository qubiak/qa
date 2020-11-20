package pl.qubiak.qa.RowMapper.SurveyMapper;

import org.springframework.jdbc.core.RowMapper;
import pl.qubiak.qa.Model.Survey.SurveyQuestion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyQuestionRowMapper implements RowMapper <SurveyQuestion> {

    @Override
    public SurveyQuestion mapRow(ResultSet resultSet, int i) throws SQLException {

        SurveyQuestion surveyQuestion = new SurveyQuestion();
        surveyQuestion.setId(resultSet.getInt("id"));
        surveyQuestion.setSurveyQuestion(resultSet.getString("surveyQuestion"));

        return surveyQuestion;
    }
}

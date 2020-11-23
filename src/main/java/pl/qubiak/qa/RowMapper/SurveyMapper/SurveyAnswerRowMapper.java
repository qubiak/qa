package pl.qubiak.qa.RowMapper.SurveyMapper;

import org.springframework.jdbc.core.RowMapper;
import pl.qubiak.qa.Model.Survey.SurveyAnswer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyAnswerRowMapper implements RowMapper<SurveyAnswer> {

    @Override
    public SurveyAnswer mapRow(ResultSet resultSet, int i) throws SQLException {

        SurveyAnswer surveyAnswer = new SurveyAnswer();
        surveyAnswer.setId(resultSet.getInt("id"));
        surveyAnswer.setSurveyQuestionId(resultSet.getInt("surveyQuestionId"));
        surveyAnswer.setSurveyAnswer(resultSet.getString("surveyAnswer"));
        surveyAnswer.setNumberOfSelections(resultSet.getInt("numberOfSelections"));

        return surveyAnswer;
    }
}

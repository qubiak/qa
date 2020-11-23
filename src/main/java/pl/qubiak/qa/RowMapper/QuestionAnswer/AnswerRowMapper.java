package pl.qubiak.qa.RowMapper.QuestionAnswer;

import org.springframework.jdbc.core.RowMapper;
import pl.qubiak.qa.Model.QuestionAnswer.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerRowMapper implements RowMapper<Answer> {

    @Override
    public Answer mapRow(ResultSet resultSet, int i) throws SQLException {
        Answer answer = new Answer();
        answer.setId(resultSet.getInt("id"));
        answer.setQuestionId(resultSet.getInt("questionId"));
        answer.setAnswer(resultSet.getString("answer"));

        return answer;
    }
}

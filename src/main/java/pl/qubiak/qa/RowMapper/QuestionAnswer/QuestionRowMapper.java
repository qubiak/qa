package pl.qubiak.qa.RowMapper.QuestionAnswer;

import org.springframework.jdbc.core.RowMapper;
import pl.qubiak.qa.Model.QuestionAnswer.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper <Question> {

    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {

        Question question = new Question();
        question.setId(resultSet.getInt("id"));
        question.setQuestion(resultSet.getString("question"));
        question.setLike_counter(resultSet.getInt("like_counter"));
        question.setRoomId(resultSet.getInt("roomId"));

        return question;
    }
}

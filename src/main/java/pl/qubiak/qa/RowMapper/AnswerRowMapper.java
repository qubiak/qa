package pl.qubiak.qa.RowMapper;

import pl.qubiak.qa.Model.Answer;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerRowMapper implements RowMapper {

    @Override
    public Answer mapRow(ResultSet resultSet, int i) throws SQLException {
        Answer answer = new Answer();
        answer.setId(resultSet.getInt("id"));
        answer.setQuestionId(resultSet.getInt("question id"));
        answer.getAnswer(resultSet.getString("answer"));


    }
}

package pl.qubiak.qa.RowMapper;

import org.springframework.jdbc.core.RowMapper;
import pl.qubiak.qa.Model.QaModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QaRowMapper implements RowMapper <QaModel> {

    @Override
    public QaModel mapRow(ResultSet resultSet, int i) throws SQLException {

        QaModel qaModel = new QaModel();
        qaModel.setId(resultSet.getInt("id"));
        qaModel.setQuestion(resultSet.getString("question"));
        qaModel.setAnswer(resultSet.getString("answer"));
        qaModel.setCounter(resultSet.getInt("like_counter"));

        return qaModel;
    }
}

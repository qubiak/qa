package pl.qubiak.qa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.Model.QaModel;
import pl.qubiak.qa.RowMapper.QaRowMapper;

import java.util.List;
import java.util.Map;

@Repository
public class QaDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveQuestion(String question) {
        String sql = "INSERT INTO qa (question, like_counter) VALUES (?, 0);";
        jdbcTemplate.update(sql, new Object[]{question});
    }

    public void saveAnswer(int id, String answer) {
        String sql = "UPDATE qa SET answer = ? WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{answer, id});
    }

    public List<Map<String, Object>> showById(int id) {
        String sql = "SELECT * FROM qa WHERE id = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{id});
    }

    public List<QaModel> showEverything() {
        String sql = "SELECT * FROM qa";
        List<QaModel> qaModels = jdbcTemplate.query(sql, new QaRowMapper());
        return qaModels;
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
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new QaRowMapper()).getCounter();
    }

    public void saveLikeCounter(int id) {
        String sql = "UPDATE qa SET like_counter = like_counter + 1 where ID = ?";
        jdbcTemplate.update(sql, id);
    }

    public void saveDissLikeCounter(int id) {
        String sql = "UPDATE qa SET like_counter = like_counter - 1 where ID = ?";
        jdbcTemplate.update(sql, id);
    }

    /*
    public void saveEverything(QaModel qa) {
        String sql = "INSERT INTO qa VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, new Object[]{
                qa.getId(),
                qa.getQuestion(),
                qa.getAnswer(),
                qa.getCounter()
        });
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit2() {
        saveEverything(new QaModel("ile nóg ma stonoga?", "16"));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit3() {
        saveEverything(new QaModel("Czy to zadziałą?"));
    }
     */
}

package pl.qubiak.qa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
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
        String sql = "INSERT INTO qa (question) VALUES (?);";
        jdbcTemplate.update(sql, new Object[]{question});

        System.out.println(question);
    }

    public void saveAnswer(int id, String answer) {
        String sql = "UPDATE qa SET answer = ? WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{answer, id});

        System.out.println(id);
        System.out.println(answer);
    }

    public List<Map<String, Object>> showById(int id){
        String sql = "SELECT * FROM qa WHERE id LIKE ?";
        return jdbcTemplate.queryForList(sql, new Object[]{id});
    }

    public List<Map<String, Object>> showEverything() {
        String sql = "SELECT * FROM qa";
        return jdbcTemplate.queryForList(sql, new Object[]{});
    }

    public List<Map<String, Object>> showIdAndQuestion() {
        String sql = "SELECT CONCAT(id, '. ', question) FROM qa";
        return jdbcTemplate.queryForList(sql, new Object[]{});
    };

    public void delateByID(int id) {
        String sql = "DELETE FROM `qa` WHERE `qa`.`id` = ?;";
        jdbcTemplate.update(sql, new Object[]{id});
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

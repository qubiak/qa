package pl.qubiak.qa.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.Model.Room;
import pl.qubiak.qa.RowMapper.RoomRowMapper;

import java.util.List;

@Repository
public class RoomDao {

    private JdbcTemplate jdbcTemplate;

    public RoomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createNewRoom(String roomName) {
        String sql = "INSERT INTO room (roomName) VALUE  (?)";
        jdbcTemplate.update(sql, new Object[]{roomName});
    }

    public List<Room> showAllRoom() {
        String sql = "SELECT * FROM room";
        List<Room> rooms = jdbcTemplate.query(sql, new RoomRowMapper());
        return rooms;
    }


}

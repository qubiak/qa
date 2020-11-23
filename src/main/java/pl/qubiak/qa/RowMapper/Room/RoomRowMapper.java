package pl.qubiak.qa.RowMapper.Room;

import org.springframework.jdbc.core.RowMapper;
import pl.qubiak.qa.Model.Room.Room;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomRowMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet resultSet, int i) throws SQLException {

        Room room = new Room();
        room.setId(resultSet.getInt("id"));
        room.setRoomName(resultSet.getString("roomName"));

        return room;
    }
}

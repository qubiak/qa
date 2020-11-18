package pl.qubiak.qa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.DAO.RoomDao;
import pl.qubiak.qa.Model.Room;

import java.util.List;

@Controller
@RequestMapping("/Room")
public class RoomController {

    @Autowired
    public RoomDao roomDao;

    @RequestMapping("/createNewRoom")
    @ResponseBody
    public void createNewRoom(
            @RequestParam("roomName") String roomName) {
        roomDao.createNewRoom(roomName);
    }

    @RequestMapping("/showAllRooms")
    @ResponseBody
    public List<Room> showAllRooms() {
        return roomDao.showAllRoom();
    }
}

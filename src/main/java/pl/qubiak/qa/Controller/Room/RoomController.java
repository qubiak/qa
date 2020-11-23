package pl.qubiak.qa.Controller.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.DAO.Room.RoomDao;
import pl.qubiak.qa.Model.Room.Room;
import java.util.List;

@Controller
@RequestMapping("/Room")
public class RoomController {

    @Autowired
    public RoomDao roomDao;

    @RequestMapping("/createNewRoom")
    @ResponseBody
    //http://localhost:8080/Room/createNewRoom?roomName=test
    public void createNewRoom(
            @RequestParam("roomName") String roomName) {
        roomDao.createNewRoom(roomName);
    }

    @RequestMapping("/showAllRooms")
    @ResponseBody
    //http://localhost:8080/Room/showAllRooms
    public List<Room> showAllRooms() {
        return roomDao.showAllRoom();
    }
}

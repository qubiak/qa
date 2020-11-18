package pl.qubiak.qa.Model;

import io.swagger.annotations.ApiModelProperty;

public class Room {

    @ApiModelProperty(notes = "AUTO_INCREMENT")
    private int id;
    private String roomName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}

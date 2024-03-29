package mrs.domain.model;

import javax.persistence.*;

@Entity
public class MeetingRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomId;
	private String roomName;

	public MeetingRoom() {
	}

	public MeetingRoom(Integer roomId, String roomName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "MeetingRoom [roomId=" + roomId + ", roomName=" + roomName + "]";
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	
}

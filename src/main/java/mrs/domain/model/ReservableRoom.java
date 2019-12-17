package mrs.domain.model;

import javax.persistence.*;

@Entity
public class ReservableRoom {
	@EmbeddedId
	private ReservableRoomId reservableRoomId;
	
	@ManyToOne
	@JoinColumn(name = "room_id", insertable = false, updatable = false)
	@MapsId("roomId")
	private MeetingRoom meetingRoom;
	
	public ReservableRoom(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}
	
	public ReservableRoom() {
	}

	public ReservableRoom(ReservableRoomId reservableRoomId, MeetingRoom meetingRoom) {
		super();
		this.reservableRoomId = reservableRoomId;
		this.meetingRoom = meetingRoom;
	}

	@Override
	public String toString() {
		return "ReservableRoom [reservableRoomId=" + reservableRoomId + ", meetingRoom=" + meetingRoom + "]";
	}

	public ReservableRoomId getReservableRoomId() {
		return reservableRoomId;
	}

	public void setReservableRoomId(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}
	
	
}

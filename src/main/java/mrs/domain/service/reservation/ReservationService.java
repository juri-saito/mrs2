package mrs.domain.service.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.repository.reservation.ReservationRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ReservableRoomRepository reservableRoomRepository;

	public List<Reservation> findReservations(ReservableRoomId reservableRoomId) {
		return reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);
	}

	public Reservation reserve(Reservation reservation) {
		ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();
		// 対象の部屋が予約可能かどうかチェック
		ReservableRoom reservable = reservableRoomRepository.findOne(reservableRoomId);
		if (reservable == null) {
			// 例外をスローする。スローする例外については後述
		}
		// 重複チェック
		boolean overlap = reservationRepository
				.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId).stream()
				.anyMatch(x -> x.overlap(reservation));
		if(overlap) {
			//例外をスローする。スローする例外については後述。
		}
		//予約情報の登録
		reservationRepository.save(reservation);
		return reservation;
	}
	
	
}

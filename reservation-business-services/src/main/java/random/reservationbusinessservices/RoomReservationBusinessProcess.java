package random.reservationbusinessservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import random.reservationbusinessservices.client.GuestService;
import random.reservationbusinessservices.client.ReservationService;
import random.reservationbusinessservices.client.RoomService;
import random.reservationbusinessservices.domain.Guest;
import random.reservationbusinessservices.domain.Reservation;
import random.reservationbusinessservices.domain.Room;
import random.reservationbusinessservices.domain.RoomReservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomReservationBusinessProcess {

    @Autowired
    private GuestService guestService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ReservationService reservationService;

    public List<RoomReservation> getRoomReservationsForDate(String dateString) {
        List<Room> rooms = roomService.findAll(null);
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
        Iterable<Reservation> reservations = reservationService.findAll(dateString);
        if (null != reservations) {
            reservations.forEach(reservation -> {
                Guest guest = guestService.findOne(reservation.getGuestId());
                if (null != guest) {
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
                    roomReservation.setDate(reservation.getReservationDate());
                    roomReservation.setFirstName(guest.getFirstName());
                    roomReservation.setLastName(guest.getLastName());
                    roomReservation.setGuestId(guest.getId());
                }

            });
        }
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long roomId : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;
    }

}

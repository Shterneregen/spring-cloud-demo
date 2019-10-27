package random.reservationwebapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import random.reservationwebapp.domain.Room;
import random.reservationwebapp.domain.RoomReservation;

import java.util.List;

@FeignClient("RESERVATIONBUSINESSSERVICES")
public interface RoomReservationService {

    @GetMapping(value = "/rooms")
    public List<Room> getAllRooms(@RequestParam(name = "roomNumber", required = false) String roomNumber);

    @GetMapping(value = "/roomReservations/{date}")
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date);
}

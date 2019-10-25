package random.reservationbusinessservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import random.reservationbusinessservices.client.RoomService;
import random.reservationbusinessservices.domain.Room;

import java.util.List;

@RestController
public class RoomReservationController {

    @Autowired
    private RoomService roomService;

    @GetMapping(path = "/rooms")
    public List<Room> getAllRooms() {
        return roomService.findAll(null);
    }
}

package random.reservationbusinessservices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import random.reservationbusinessservices.client.RoomService;
import random.reservationbusinessservices.domain.Room;
import random.reservationbusinessservices.domain.RoomReservation;

import java.util.List;

@RestController
@Api(value = "RoomReservations", tags = {"roomReservations"})
@SwaggerDefinition(tags = {
        @Tag(name = "roomReservations", description = "Business process service operations on rooms and reservations")
})
public class RoomReservationController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomReservationBusinessProcess businessProcess;

    @GetMapping(value = "/rooms")
    @ApiOperation(value = "Get All Rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    public List<Room> getAllRooms(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        return roomService.findAll(roomNumber);
    }

    @GetMapping(value = "/roomReservations/{date}")
    @ApiOperation(value = "Get Room Reservations", notes = "Gets all reservations for a specific date",
            nickname = "getReservationsForDate")
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date) {
        return businessProcess.getRoomReservationsForDate(date);
    }

}

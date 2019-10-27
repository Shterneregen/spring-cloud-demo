package random.reservationwebapp;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import random.reservationwebapp.client.RoomReservationService;
import random.reservationwebapp.domain.RoomReservation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private RoomReservationService roomReservationService;

    @GetMapping
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        String date = dateString;
        if (StringUtils.isBlank(dateString)) {
            date = createTodayDateString();
        }
        List<RoomReservation> roomReservations = roomReservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "reservations";
    }

    public String createTodayDateString() {
        return DATE_FORMAT.format(new Date());
    }
}
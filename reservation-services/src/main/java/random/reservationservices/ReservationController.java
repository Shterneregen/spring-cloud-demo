package random.reservationservices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import random.reservationservices.utils.DateTimeUtils;
import random.reservationservices.utils.ReservationTranslator;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/reservations")
@Api(value = "reservations", tags = ("reservations"))
@SwaggerDefinition(tags = {
        @Tag(name = "reservations", description = "Data service operations on reservations")
})
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private DateTimeUtils dateTimeUtils;
    @Autowired
    private ReservationTranslator reservationTranslator;

    @GetMapping
    @ApiOperation(value = "Get All Reservations", notes = "Gets all reservations in the system",
            nickname = "getReservations")
    public List<Reservation> findAll(@RequestParam(name = "date", required = false) String date) {
        List<ReservationEntity> entities;
        if (StringUtils.isNotBlank(date)) {
            entities = reservationRepository.findByDate(dateTimeUtils.createDateFromDateString(date));
        } else {
            entities = (List<ReservationEntity>) reservationRepository.findAll();
        }
        List<Reservation> reservations = new ArrayList<>(entities.size());
        entities.forEach(entity -> reservations.add(reservationTranslator.translateEntityToReservation(entity)));
        return reservations;
    }
}

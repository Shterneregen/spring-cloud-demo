package random.reservationbusinessservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import random.reservationbusinessservices.domain.Reservation;

import java.util.List;

@FeignClient("RESERVATIONSERVICES")
public interface ReservationService {
    @GetMapping(value = "/reservations")
    List<Reservation> findAll(@RequestParam(name = "date", required = false) String date);
}

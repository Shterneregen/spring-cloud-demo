package random.reservationbusinessservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import random.reservationbusinessservices.domain.Guest;

import java.util.List;

@FeignClient(value = "GUESTSERVICES", fallback = GuestServiceFallbackImpl.class)
public interface GuestService {

    @GetMapping(value = "/guests")
    public abstract List<Guest> findAll(@RequestParam(name = "emailAddress", required = false) String emailAddress);

    @GetMapping(value = "/guests/{id}")
    public abstract Guest findOne(@PathVariable(name = "id") long id);
}

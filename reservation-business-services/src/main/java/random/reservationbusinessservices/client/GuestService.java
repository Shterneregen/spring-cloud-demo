package random.reservationbusinessservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import random.reservationbusinessservices.domain.Guest;

import java.util.List;

@FeignClient("GUESTSERVICES")
public interface GuestService {

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    public abstract List<Guest> findAll(@RequestParam(name = "emailAddress", required = false) String emailAddress);

    @RequestMapping(value = "/guests/{id}", method = RequestMethod.GET)
    public abstract Guest findOne(@PathVariable(name = "id") long id);
}

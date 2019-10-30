package random.reservationservices.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import random.reservationservices.Reservation;
import random.reservationservices.ReservationEntity;

import java.sql.Date;

@Component
public class ReservationTranslator {

    @Autowired
    private DateTimeUtils dateTimeUtils;

    public Reservation translateEntityToReservation(ReservationEntity reservationEntity) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationEntity.getId());
        reservation.setRoomId(reservationEntity.getRoomId());
        reservation.setGuestId(reservationEntity.getGuestId());
        reservation.setReservationDate(dateTimeUtils.createDateStringFromDate(reservationEntity.getDate()));
        return reservation;
    }

    public ReservationEntity translateReservationToEntity(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();
        entity.setGuestId(reservation.getGuestId());
        entity.setId(reservation.getId());
        entity.setRoomId(reservation.getRoomId());
        entity.setDate(new Date(dateTimeUtils.createDateFromDateString(reservation.getReservationDate()).getTime()));
        return entity;
    }
}

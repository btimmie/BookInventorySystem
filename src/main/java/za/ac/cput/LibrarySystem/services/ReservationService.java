package za.ac.cput.LibrarySystem.services;

import za.ac.cput.LibrarySystem.domain.Impl.Member;
import za.ac.cput.LibrarySystem.domain.Impl.Reservation;

import java.util.List;

/**
 * Created by Branwyn on 2015-05-17.
 */
public interface ReservationService {
    List<Reservation> getReservation();
    Member getMember(Long ID);
}

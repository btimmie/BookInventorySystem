package za.ac.cput.LibrarySystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.LibrarySystem.domain.Impl.Member;
import za.ac.cput.LibrarySystem.domain.Impl.Reservation;
import za.ac.cput.LibrarySystem.repository.ReservationRepository;
import za.ac.cput.LibrarySystem.services.ReservationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Branwyn on 2015-05-17.
 */
@Service
public class ReservationServiceImp implements ReservationService {
    @Autowired
    ReservationRepository repository;
    public List<Reservation> getReservation() {
        List<Reservation> reservationList = new ArrayList<Reservation>();
        Iterable<Reservation> reservations = repository.findAll();
        for (Reservation r : reservations){
            reservationList.add(r);
        }

        return reservationList;
    }

    public Member getMember(Long ID) {
        return repository.findOne(ID).getMember();
    }
}

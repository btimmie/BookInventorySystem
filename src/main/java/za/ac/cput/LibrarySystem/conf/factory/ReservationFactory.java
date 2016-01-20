package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Member;
import za.ac.cput.LibrarySystem.domain.Impl.Reservation;

import java.util.Date;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class ReservationFactory {
   public static Reservation createReservation(Date reservedDate,Member member,Book book){
       return new Reservation.Builder()
               .reservedDate(reservedDate)
               .book(book)
               .member(member).build();
   }
}

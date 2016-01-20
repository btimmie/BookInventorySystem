package za.ac.cput.LibrarySystem.domain;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.ReservationFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Member;
import za.ac.cput.LibrarySystem.domain.Impl.Reservation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class ReservationTest extends TestCase{
    @Test
    public void testCreateReservation() throws Exception {
        Member member = new Member.Builder("PQ223").firstName("Songezo").lastName("Jele").build();
        Book book = new Book.Builder("8-77-5555-8888").build();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Reservation reservation = ReservationFactory.createReservation(date,member,book);

        assertEquals(dateFormat.format(date),dateFormat.format(reservation.getReservedDate()));
        //assertEquals("8-77-5555-8888",reservation.getBook().getISBN());
    }

    public void testUpdate() throws Exception {
        Member member = new Member.Builder("PQ223").firstName("Songezo").lastName("Jele").build();
        Book book = new Book.Builder("8-77-5555-8888").build();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Reservation reservation = ReservationFactory.createReservation(date, member, book);

        Reservation newRervation = new Reservation.Builder().copy(reservation).reservedDate(date).build();

        assertEquals(dateFormat.format(date), dateFormat.format(newRervation.getReservedDate()));
        assertEquals("PQ223",newRervation.getMember().getMember_id());
        assertEquals("8-77-5555-8888",newRervation.getBook().getISBN());
        assertEquals("8-77-5555-8888",reservation.getBook().getISBN());

    }
}

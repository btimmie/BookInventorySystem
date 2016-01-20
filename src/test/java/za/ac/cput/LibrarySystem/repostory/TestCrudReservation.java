package za.ac.cput.LibrarySystem.repostory;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.LibrarySystem.App;
import za.ac.cput.LibrarySystem.domain.Impl.Reservation;
import za.ac.cput.LibrarySystem.repository.ReservationRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Branwyn on 2015-05-03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudReservation extends AbstractTestNGSpringContextTests{

    private Long id;
    @Autowired
    ReservationRepository repository;
    @Test
    public void testCreate() throws Exception {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2015/05/03");
        Reservation reservation =  new Reservation.Builder().reservedDate(date).build();
        repository.save(reservation);
        id = reservation.getId();
        Assert.assertNotNull(reservation.getReservedDate());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Reservation res = repository.findOne(id);
        Assert.assertEquals("2015/05/03",format.format(res.getReservedDate()));
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Reservation res = repository.findOne(id);
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2013/04/26");
        Reservation reservation =  new Reservation.Builder().copy(res)
                .reservedDate(date)
                .build();
        Assert.assertEquals("2013/04/26", new SimpleDateFormat("yyyy/MM/dd").format(reservation.getReservedDate()) );
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Reservation res = repository.findOne(id);
        repository.delete(res);
        Reservation r = repository.findOne(id);
        Assert.assertNull(r);
    }
}

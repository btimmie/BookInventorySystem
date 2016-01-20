package za.ac.cput.LibrarySystem.repostory;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.LibrarySystem.App;
import za.ac.cput.LibrarySystem.domain.Impl.DVD;
import za.ac.cput.LibrarySystem.repository.DVDRepository;

/**
 * Created by Branwyn on 2015-05-03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudDVD extends AbstractTestNGSpringContextTests{
    private Long id;
    @Autowired
    DVDRepository dvdRepository;

    @Test
    public void testCreate() throws Exception {
        DVD dvd = new DVD.Builder("111")
                .duration(20)
                .tittle("Early Childhood Education and Psychology")
                .distributor("UCT")
                .subject("Psychology")
                .build();
        dvdRepository.save(dvd);
        id = dvd.getId();
        Assert.assertNotNull(dvd.getTittle());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        DVD dvd = dvdRepository.findOne(id);
        Assert.assertEquals("Early Childhood Education and Psychology",dvd.getTittle());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        DVD dvd = dvdRepository.findOne(id);
        DVD newdvd = new DVD.Builder(dvd.getCode())
                .subject("Art Therapy")
                .tittle("Art Therapy the Person-Centred Way")
                .build();
        Assert.assertEquals("Art Therapy the Person-Centred Way",newdvd.getTittle());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        DVD dvd = dvdRepository.findOne(id);
        dvdRepository.delete(dvd);
        DVD d = dvdRepository.findOne(id);
        Assert.assertNull(d);
    }

}

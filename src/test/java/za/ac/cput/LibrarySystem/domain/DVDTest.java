package za.ac.cput.LibrarySystem.domain;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.DVDFactory;
import za.ac.cput.LibrarySystem.domain.Impl.DVD;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class DVDTest extends TestCase{
    @Test
    public void testCreateDVD() throws Exception {
        Map<String,String> value = new HashMap<String, String>();
        value.put("code","dvd-111-23");
        value.put("tittle","Early Childhood Education and Psychology");
        value.put("subject","Psychology");
        value.put("distributor","UCT");

        DVD dvd = DVDFactory.createDVD(90,value);
        assertEquals("Early Childhood Education and Psychology",dvd.getTittle());

    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> value = new HashMap<String, String>();
        value.put("code","dvd-111-23");
        value.put("tittle","Early Childhood Education and Psychology");
        value.put("subject","Psychology");
        value.put("distributor","UCT");

        DVD dvd = DVDFactory.createDVD(90,value);
        DVD newdvd = new DVD.Builder(dvd.getCode())
                .copy(dvd)
                .tittle("Art Therapy the Person-Centred Way")
                .subject("Art Therapy")
                .duration(55)
                .build();
        assertEquals("Art Therapy the Person-Centred Way",newdvd.getTittle());
        assertEquals("Early Childhood Education and Psychology",dvd.getTittle());
        assertEquals(55,newdvd.getDuration());
        assertEquals(90,dvd.getDuration());

    }
}

package za.ac.cput.LibrarySystem.domain;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.AddressFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Address;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class AddressTest extends TestCase{
    @Test
    public void testCreateAddress() throws Exception {
        Map<String,String> value = new HashMap<String, String>();
        value.put("street","Tano");
        value.put("suburb","Delft");
        value.put("postalCode","7100");
        Address address = AddressFactory.createAddress(value,2);

        assertEquals(2,address.getHouseNumber());
        assertEquals("Tano",address.getStreet());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> value = new HashMap<String, String>();
        value.put("street","Tano");
        value.put("suburb","Delft");
        value.put("postalCode","7100");
        Address address = AddressFactory.createAddress(value,2);
        Address newAddress = new Address.Builder()
                .copy(address)
                .houseNumber(4)
                .street("Gabon")
                .build();

        assertEquals(4,newAddress.getHouseNumber());
        assertEquals("Gabon",newAddress.getStreet());
        assertEquals("Delft",newAddress.getSuburb());
        assertEquals("Delft",address.getSuburb());
        assertEquals(2,address.getHouseNumber());

    }
}

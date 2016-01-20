package za.ac.cput.LibrarySystem.domain;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.CopyFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class CopyTest extends TestCase{
    @Test
    public void testCreateCopy() throws Exception {
        Copy copy = CopyFactory.createCopy("11111-2222","22-May-2015","slightly damaged");

        assertEquals("11111-2222",copy.getAccessionNumber());
        assertEquals("22-May-2015",copy.getDatePurchased());
        assertEquals("slightly damaged",copy.getCopy_Notes());

    }
    @Test
    public void testUpdateCopy() throws Exception {
        Copy copy = CopyFactory.createCopy("11111-2222","22-May-2015","slightly damaged");
        Copy newCopy = new Copy.Builder("1111-33").copy(copy).datePurchased("12-July-2014").copy_Notes("newer").build();

        assertEquals(copy.getAccessionNumber(),newCopy.getAccessionNumber());
        assertEquals("12-July-2014",newCopy.getDatePurchased());
        assertEquals("newer",newCopy.getCopy_Notes());
        assertEquals("slightly damaged",copy.getCopy_Notes());
    }


}

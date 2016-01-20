package za.ac.cput.LibrarySystem.domain;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.LibrarianFatory;
import za.ac.cput.LibrarySystem.domain.Impl.Librarian;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class LibrarianTest extends TestCase{

    @Test
    public void testCreateLibrarian() throws Exception {
        Librarian librarian = LibrarianFatory.createLibrarian("LB100", "Ngwenduna", "Yongama");
        assertEquals("Yongama",librarian.getFName());

    }

    @Test
    public void testUpdate() throws Exception {
        Librarian librarian = LibrarianFatory.createLibrarian("LB100", "Ngwenduna", "Yongama");
        Librarian newLibrarian = new Librarian.Builder(librarian.getLibrarianID()).copy(librarian).fName("Thules").build();
        assertEquals("Thules",newLibrarian.getFName());
        assertEquals("Ngwenduna",newLibrarian.getLName());
        assertEquals("Yongama",librarian.getFName());
    }
}

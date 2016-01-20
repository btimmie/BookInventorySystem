package za.ac.cput.LibrarySystem.domain;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.AuthorFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Author;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class AuthorTest extends TestCase{
    @Test
    public void testCreateAuthor() throws Exception {
        Author author = AuthorFactory.createAuthor("Lesley","Robertson");
        assertEquals("Lesley",author.getFName());
    }

    @Test
    public void testUpdate() throws Exception {
        Author author = AuthorFactory.createAuthor("Lesley","Robertson");
        Author newAuthor = new Author.Builder()
                .copy(author)
                .fName("Jason")
                .lName("Laray")
                .build();
        assertEquals("Jason",newAuthor.getFName());
        assertEquals("Laray",newAuthor.getLName());
        assertEquals("Lesley",author.getFName());
        assertEquals("Robertson",author.getLName());
    }
}

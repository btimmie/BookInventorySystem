package za.ac.cput.LibrarySystem.services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.LibrarySystem.App;
import za.ac.cput.LibrarySystem.conf.factory.CopyFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Author;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.domain.Impl.Publisher;
import za.ac.cput.LibrarySystem.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Branwyn on 2015-05-21.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class BookServiceTest extends AbstractTestNGSpringContextTests{

    private Long idd;
    @Autowired
    BookRepository rep;
    @Autowired
    private BookService service;
    private List<Copy> copies;
    private Book item;
/*

    @BeforeMethod
    public void setUp() throws Exception {
        copies = new ArrayList<>();


    }

    @Test
    public void testCreate() throws Exception {
        Copy cop1 = CopyFactory.createCopy("1001", "22-May-2015", "slightly damaged");
        Copy cop2 = CopyFactory.createCopy("1002", "20-June-2015", "Newer cover");

        List<Copy> copyList = new ArrayList<Copy>();
        copyList.add(cop1);
        copyList.add(cop2);

        item = new Book.Builder("978-1-4080-4863-4")
                .tittle("Database Principles : Fundamentals of Design, implementations, and Management")
                .subject("Database")
                .authors(new Author.Builder()
                        .fName("Coronel")
                        .lName("Carlos")
                        .build())
                .publisher(new Publisher.Builder()
                        .publisherName("Cengage Learning")
                        .placeOfPublication("2006")
                        .build())
                .copies(copyList)
                .build();
        rep.save(item);
        idd = item.getId();
        Assert.assertNotNull(item.getSubject());
    }

    @Test(dependsOnMethods = "testCreate" )
    public void testBookCopies() throws Exception {
        copies = service.getCopies(idd);
        org.testng.Assert.assertTrue(copies.size() == 2);

    }

    @Test(dependsOnMethods = "testBookCopies")
    public void tearDown() throws Exception {
        rep.deleteAll();

    }*/
}

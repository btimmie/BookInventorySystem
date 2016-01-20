package za.ac.cput.LibrarySystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import za.ac.cput.LibrarySystem.domain.*;

/**
 * Created by Branwyn on 2015-04-26.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AddressTest.class,
        AuthorTest.class,
        BookTest.class,
        CopyTest.class,
        DVDTest.class,
        LibrarianTest.class,
        LoanTest.class,
        MemberTest.class,
        PublisherTest.class,
        ReservationTest.class})
public class DomainTestSuite {
}

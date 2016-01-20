package za.ac.cput.LibrarySystem.domain;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.PublisherFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Publisher;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class PublisherTest extends TestCase {
    @Test
    public void testCreatePublisher() throws Exception {
        Publisher publisher = PublisherFactory.createPublisher("Cengage Brain","Australia");

        assertEquals("Cengage Brain",publisher.getPublisherName());
    }

    @Test
    public void testUpdate() throws Exception {
        Publisher publisher = PublisherFactory.createPublisher("Cengage Brain","Australia");
        Publisher newpublisher = new Publisher.Builder().copy(publisher).publisherName("Thomson").build();

        assertEquals("Thomson",newpublisher.getPublisherName());
        assertEquals("Australia",newpublisher.getPlaceOfPublication());
        assertEquals("Australia",publisher.getPlaceOfPublication());
    }
}

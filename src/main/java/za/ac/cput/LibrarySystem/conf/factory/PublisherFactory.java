package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Publisher;

/**
 * Created by Branwyn on 2015-04-25.
 */
public class PublisherFactory {
    public static Publisher createPublisher(String name, String country){

        return new Publisher.Builder()
                .publisherName(name)
                .placeOfPublication(country)
                .build();
    }
}

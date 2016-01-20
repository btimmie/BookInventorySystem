package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Address;
import za.ac.cput.LibrarySystem.domain.Impl.Author;

/**
 * Created by Branwyn on 2015-04-25.
 */
public class AuthorFactory {

    public static Author createAuthor(String firstName, String lastName){
        return new Author.Builder()
                       .fName(firstName)
                       .lName(lastName)
                       .build();

    }
}

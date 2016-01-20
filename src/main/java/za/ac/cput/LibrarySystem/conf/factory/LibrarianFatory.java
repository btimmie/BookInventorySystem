package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Librarian;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class LibrarianFatory {
    public static Librarian createLibrarian(String librarian_id,String lastName, String firstName){
        return new Librarian.Builder(librarian_id)
                .fName(firstName)
                .lName(lastName)
                .build();
    }
}

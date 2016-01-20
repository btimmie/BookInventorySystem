package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Copy;

/**
 * Created by Branwyn on 2015-04-25.
 */
public class CopyFactory {

    public static Copy createCopy(String accessionNumber,String date, String notes){
        return new Copy.Builder(accessionNumber)
                .datePurchased(date)
                .copy_Notes(notes)
                .build();
    }
}

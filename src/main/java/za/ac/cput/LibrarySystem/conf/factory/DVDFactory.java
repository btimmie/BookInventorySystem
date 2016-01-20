package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.DVD;

import java.util.Map;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class DVDFactory {
    public static DVD createDVD(int duration, Map<String,String> value){
        return new DVD.Builder(value.get("code"))
                .tittle(value.get("tittle"))
                .subject(value.get("subject"))
                .distributor("distributor")
                .duration(duration).build();
    }
}

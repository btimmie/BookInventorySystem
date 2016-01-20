package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Author;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Publisher;

import java.util.List;
import java.util.Map;

/**
 * Created by Branwyn on 2015-04-25.
 */
public class BookFactory {

    public static Book createBook(Map<String,String> value,Publisher publisher,Map<String,List> list){
        return new Book.Builder(value.get("isbn"))
                .tittle(value.get("tittle"))
                .subject(value.get("subject"))
                //.type(value.get("type"))
               // .authors(list.get("authors"))
                .copies(list.get("copies"))
                .build();
    }

}


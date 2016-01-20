package za.ac.cput.LibrarySystem.domain;

import junit.framework.Assert;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.BookFactory;
import za.ac.cput.LibrarySystem.conf.factory.PublisherFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Author;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.domain.Impl.Publisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Branwyn on 2015-04-25.
 */
public class BookTest {
    @Test
    public void testCreateBook() throws Exception {
        Map<String,String> values = new HashMap<String, String>();
        Map<String,List> list = new HashMap<String, List>();
        List<Author> authors = new ArrayList<Author>();
        List<Copy> copies = new ArrayList<Copy>();
        Publisher publisher = PublisherFactory.createPublisher("Cengage Learning","Australia");
        values.put("isbn","1-4188-3674-5");
        values.put("tittle","Simple Program Design");
        list.put("copies",copies);
        list.put("authors",authors);

        Book book = BookFactory.createBook(values,publisher,list);
        Assert.assertEquals("Simple Program Design",book.getTittle());

    }

    @Test
    public void testUpdate() throws Exception {

        Map<String,String> values = new HashMap<String, String>();
        Map<String,List> list = new HashMap<String, List>();
        List<Author> authors = new ArrayList<Author>();
        List<Copy> copies = new ArrayList<Copy>();
        Publisher publisher = PublisherFactory.createPublisher("Cengage Learning","Australia");
        values.put("isbn","1-4188-3674-5");
        values.put("tittle","Simple Program Design");
        list.put("copies",copies);
        list.put("authors",authors);

        Book book = BookFactory.createBook(values,publisher,list);
        Book newBook = new Book.Builder(book.getISBN())
                .copy(book)
                .tittle("Java how to program").build();

        Assert.assertEquals("Java how to program",newBook.getTittle());
        Assert.assertEquals("1-4188-3674-5",newBook.getISBN());
        Assert.assertEquals("Simple Program Design",book.getTittle());


    }
}

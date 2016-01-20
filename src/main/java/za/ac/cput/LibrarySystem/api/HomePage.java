package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.services.BookService;

import java.util.List;

/**
 * Created by Branwyn on 2015/09/13.
 */
@RestController
@RequestMapping("/library/**")
public class HomePage {
    @Autowired
    private BookService service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public Book getCourse(){
        Book book = new Book.Builder("12345")
                .tittle("The killing of kingz")
                .subject("Wars")
                .build();
        return book;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> getBooks(){
        return service.getBooks() ;
    }

}

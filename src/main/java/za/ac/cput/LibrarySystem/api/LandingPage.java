package za.ac.cput.LibrarySystem.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.LibrarySystem.domain.Impl.Book;

/**
 * Created by Branwyn on 2015/09/18.
 */
@RestController
@RequestMapping("/")
public class LandingPage {
    @RequestMapping(method = RequestMethod.GET)
    public Book getCourse(){
        Book book = new Book.Builder("12345")
                .tittle("Landing Page").subject("Checking") .build();
        return book;
    }

}

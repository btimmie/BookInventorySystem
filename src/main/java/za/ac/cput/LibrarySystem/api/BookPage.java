package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.model.BookResource;
import za.ac.cput.LibrarySystem.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Branwyn on 2015-05-17.
 */
@RestController
@RequestMapping(value = "/library/**")
public class BookPage {

    @Autowired BookService service;

    //-------------------Retrieve All Book--------------------------------------------------------

    @RequestMapping(value = "/books/", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBook() {
        List<Book> Books = service.getBooks();
        if(Books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Book>>(Books, HttpStatus.OK);
    }


    //-------------------Retrieve Single Book--------------------------------------------------------

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
        System.out.println("Fetching Book with id " + id);
        Book book = service.findById(id);
        if (book == null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }


    //-------------------Create a Book--------------------------------------------------------

    @RequestMapping(value = "/book/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody Book book,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Book " + book.getTittle());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(book);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Book --------------------------------------------------------

    @RequestMapping(value = "/book/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book Subject) {
        System.out.println("Updating Book " + id);

        Book currentBook = service.findById(id);

        if (currentBook==null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<Book>(Subject,HttpStatus.NOT_FOUND);
        }

        Book updatedBook = new Book
                .Builder(currentBook.getISBN())
                .copy(currentBook)
                .build();
        service.update(updatedBook);
        return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
    }

    //------------------- Delete a Book --------------------------------------------------------

    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Book with id " + id);

        Book book = service.findById(id);
        if (book == null) {
            System.out.println("Unable to delete. Book with id " + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

        service.delete(book);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }


}

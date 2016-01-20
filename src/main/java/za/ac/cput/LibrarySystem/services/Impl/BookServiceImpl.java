package za.ac.cput.LibrarySystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.repository.BookRepository;
import za.ac.cput.LibrarySystem.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Branwyn on 2015-05-10.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> books = bookRepository.findAll();
        for (Book b : books){
            bookList.add(b);
        }
        return bookList;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Book save(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public Book update(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public void delete(Book entity) {
        bookRepository.delete(entity);

    }


    public List<Copy> getCopies(Long ID) {
        return bookRepository.findOne(ID).getCopies();
    }
}
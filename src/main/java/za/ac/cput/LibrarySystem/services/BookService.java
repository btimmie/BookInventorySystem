package za.ac.cput.LibrarySystem.services;

import za.ac.cput.LibrarySystem.domain.Impl.Book;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;

import java.util.List;

/**
 * Created by Branwyn on 2015-05-10.
 */
public interface BookService {
    List<Book> getBooks();
    public Book findById(Long id);

    public Book save(Book entity);

    public Book update(Book entity);

    public void delete(Book entity);
    List<Copy> getCopies(Long ID);
}

package za.ac.cput.LibrarySystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.LibrarySystem.domain.Impl.Librarian;

/**
 * Created by Branwyn on 2015-05-03.
 */
public interface LibrarianRepository extends CrudRepository<Librarian,Long>{
}

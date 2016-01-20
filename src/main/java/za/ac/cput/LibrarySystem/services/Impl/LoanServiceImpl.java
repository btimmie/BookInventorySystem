package za.ac.cput.LibrarySystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.domain.Impl.Librarian;
import za.ac.cput.LibrarySystem.domain.Impl.Loan;
import za.ac.cput.LibrarySystem.domain.Impl.Member;
import za.ac.cput.LibrarySystem.repository.LoanRepository;
import za.ac.cput.LibrarySystem.services.LoanService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Branwyn on 2015-05-16.
 */
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepo;
    public List<Loan> getLoans() {
        List<Loan> loanList = new ArrayList<Loan>();
        Iterable<Loan> loans = loanRepo.findAll();
        for (Loan l : loans) {
            loanList.add(l);
        }
        return loanList;
    }

    public Librarian getLibrarian(Long ID) {
        return loanRepo.findOne(ID).getLibrarian();
    }

    public Member getMember(Long ID) {
        return loanRepo.findOne(ID).getMember();
    }
    public Copy getCopy(Long ID) {
        return loanRepo.findOne(ID).getCopy();
    }
    @Override
    public Loan findById(Long id) {
        return loanRepo.findOne(id);
    }

    @Override
    public Loan save(Loan entity) {
        return loanRepo.save(entity);
    }

    @Override
    public Loan update(Loan entity) {
        return loanRepo.save(entity);
    }

    @Override
    public void delete(Loan entity) {
        loanRepo.delete(entity);

    }


}

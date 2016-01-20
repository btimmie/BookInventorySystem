package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.domain.Impl.Librarian;
import za.ac.cput.LibrarySystem.domain.Impl.Loan;
import za.ac.cput.LibrarySystem.domain.Impl.Member;

import java.util.Map;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class LoanFactory {
    public static Loan createLoan(Map<String,String> value,Member member,Librarian librarian, Copy copy){
        return new Loan.Builder(member,librarian)
                .loanDate(value.get("loanDate"))
                .dueDate(value.get("dueDate"))
                .copy(copy)
                .member(member)
                .librarian(librarian)
                .build();
    }
}

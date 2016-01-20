package za.ac.cput.LibrarySystem.domain;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.LoanFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Librarian;
import za.ac.cput.LibrarySystem.domain.Impl.Loan;
import za.ac.cput.LibrarySystem.domain.Impl.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class LoanTest extends TestCase{
    @Test
    public void testCreateLoan() throws Exception {
        Map<String,String> value = new HashMap<String, String>();
        value.put("loanDate","25-April-2015");
        value.put("dueDate","25-April-2015");


        Member member = new Member.Builder("PQ200")
                .firstName("Yongama")
                .build();
        Librarian librarian = new Librarian.Builder("LB111").fName("Thules").build();
        Loan loan = LoanFactory.createLoan(value,member,librarian,null);

        assertEquals("25-April-2015",loan.getDueDate());
       // assertEquals("LB111",loan.getLibrarian().getLibrarianID());

    }

    @Test
    public void testUpdateLoan() throws Exception {
        Map<String,String> value = new HashMap<String, String>();
        value.put("loanDate","25-April-2015");
        value.put("dueDate","25-April-2015");


        Member member = new Member.Builder("PQ200")
                .firstName("Yongama")
                .build();
        Librarian librarian = new Librarian.Builder("LB111").fName("Thules").build();
        Loan loan = LoanFactory.createLoan(value, member, librarian,null);
        Loan newLoan = new Loan.Builder(member,librarian)
                .copy(loan)
                .dueDate("29-April-2015").build();

        assertEquals("29-April-2015",newLoan.getDueDate());
        assertEquals("25-April-2015",loan.getDueDate());

    }
}

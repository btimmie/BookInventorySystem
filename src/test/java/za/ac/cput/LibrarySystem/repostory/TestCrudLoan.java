package za.ac.cput.LibrarySystem.repostory;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.LibrarySystem.App;
import za.ac.cput.LibrarySystem.conf.factory.CopyFactory;
import za.ac.cput.LibrarySystem.conf.factory.LoanFactory;
import za.ac.cput.LibrarySystem.domain.Impl.*;
import za.ac.cput.LibrarySystem.repository.BookRepository;
import za.ac.cput.LibrarySystem.repository.CopyRepository;
import za.ac.cput.LibrarySystem.repository.LoanRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Branwyn on 2015-05-03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudLoan extends AbstractTestNGSpringContextTests{
    private Long id;
    @Autowired
    private LoanRepository repository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CopyRepository copyRepository;

    @Test
    public void testCreate() throws Exception {

        Map<String,String> value = new HashMap<String, String>();
        value.put("loanDate","03/05/2001");
        value.put("dueDate", "09/05/2001");


        Member member = new Member.Builder("PQ200")
                .firstName("Yongama")
                .Address(new Address.Builder().houseNumber(1).build())
                .lastName("Ngwenduna")
                .build();
        Librarian librarian = new Librarian.Builder("LB111").fName("Thules").build();
        Copy copy = CopyFactory.createCopy("11111-2222", "22-May-2015", "slightly damaged");

        Loan loan = LoanFactory.createLoan(value, member, librarian,copy);

        repository.save(loan);
        id = loan.getId();
        Assert.assertNotNull(loan.getDueDate());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Loan loan = repository.findOne(id);
        repository.findOne(id);
        Assert.assertEquals("03/05/2001",loan.getLoanDate());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Librarian librarian = null;
        Member member = null;
        Loan loan = repository.findOne(id);
        Loan newLoan = new Loan.Builder(member,librarian)
                .copy(loan)
                .loanDate("03/05/2015")
                .build();
        Assert.assertEquals("03/05/2015",newLoan.getLoanDate());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Loan loan = repository.findOne(id);
        repository.delete(loan);
        Loan l = repository.findOne(id);
        Assert.assertNull(l);
    }
}

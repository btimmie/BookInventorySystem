package za.ac.cput.LibrarySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.LibrarySystem.domain.Impl.*;
import za.ac.cput.LibrarySystem.services.LoanService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Branwyn on 2015-05-17.
 */

@RestController
@RequestMapping(value = "/library/**")
public class LoanPage {
    @Autowired
    LoanService services;


    //-------------------Retrieve All Loans--------------------------------------------------------

    @RequestMapping(value = "/loans/", method = RequestMethod.GET)
    public ResponseEntity<List<Loan>> listAllLoans() {
        List<Loan> loans = services.getLoans();
        if(loans.isEmpty()){
            return new ResponseEntity<List<Loan>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Loan>>(loans, HttpStatus.OK);
    }

    //-------------------Retrieve Single Subject--------------------------------------------------------

    @RequestMapping(value = "/loan/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Loan> getLoan(@PathVariable("id") long id) {
        System.out.println("Fetching Loan with id " + id);
        Loan loan = services.findById(id);
        if (loan == null) {
            System.out.println("Loan with id " + id + " not found");
            return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Loan>(loan, HttpStatus.OK);
    }

    //-------------------Create a Loan--------------------------------------------------------

    @RequestMapping(value = "/loan/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody Loan loan,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating loan " + loan.toString());

        services.save(loan);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/loan/{id}").buildAndExpand(loan.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Loan --------------------------------------------------------

    @RequestMapping(value = "/loan/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Loan> updateLoan(@PathVariable("id") long id, @RequestBody Loan Loan) {
        System.out.println("Updating Book " + id);

        Loan currentLoan = services.findById(id);

        if (currentLoan==null) {
            System.out.println("Loan with id " + id + " not found");
            return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
        }

        Loan updatedBook = new Loan
                .Builder(currentLoan.getMember(),currentLoan.getLibrarian())
                .copy(currentLoan)
                .build();
        services.update(updatedBook);
        return new ResponseEntity<Loan>(updatedBook, HttpStatus.OK);
    }

    //------------------- Delete a Loan --------------------------------------------------------

    @RequestMapping(value = "/loan/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Loan> deleteLoan(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Loan with id " + id);

        Loan loan = services.findById(id);
        if (loan == null) {
            System.out.println("Unable to delete. Book with id " + id + " not found");
            return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
        }

        services.delete(loan);
        return new ResponseEntity<Loan>(HttpStatus.NO_CONTENT);
    }

}

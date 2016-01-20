package za.ac.cput.LibrarySystem.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.domain.Impl.Librarian;
import za.ac.cput.LibrarySystem.domain.Impl.Member;

/**
 * Created by Branwyn on 2015-05-19.
 */
public class LoanResource extends ResourceSupport {
    private Long resID;
    private String loanDate;
    private String dueDate;
    private Member member;
    private Librarian librarian;
    private Copy copy;

    private LoanResource(){}
    public LoanResource(Builder builder){

        resID = builder.resID;
        loanDate = builder.loanDate;
        member = builder.member;
        librarian= builder.librarian;
        copy = builder.copy;
        dueDate = builder.dueDate;


    }
    public Long getresID() {
        return resID;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public Member getMember() {
        return member;
    }

    public Copy getCopy() {
        return copy;
    }

    public static class Builder{

        Long resID;
        private String loanDate;
        private String dueDate;
        private Member member;
        private Librarian librarian;
        private Copy copy;

        public Builder(Member member, Librarian librarian){
            this.librarian = librarian;
            this.member = member;
        }

        public Builder resID(Long value){
            this.resID = value;
            return this;
        }

        public Builder loanDate(String value){
            this.loanDate = value;
            return this;
        }
        public Builder dueDate(String value){
            this.dueDate = value;
            return this;
        }

        public Builder member(Member value){
            this.member = value;
            return this;
        }

        public Builder copy(Copy  value){
            this.copy = value;
            return this;
        }

        public Builder librarian(Librarian value){
            this.librarian = value;
            return this;
        }
        public Builder copy(LoanResource loan){
            this.copy = loan.copy;
            this.loanDate = loan.loanDate;
            this.member = loan.member;
            this.librarian = loan.librarian;
            return this;
        }

        public LoanResource build() {
            return new LoanResource(this);
        }

    }
}

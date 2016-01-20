package za.ac.cput.LibrarySystem.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.LibrarySystem.domain.Impl.Author;
import za.ac.cput.LibrarySystem.domain.Impl.Copy;
import za.ac.cput.LibrarySystem.domain.Impl.Publisher;

import java.util.List;

/**
 * Created by Branwyn on 2015-05-19.
 */
public class BookResource extends ResourceSupport {

    private Long resID;
    private String tittle;
    private String subject;
    private String ISBN;
    private Author author;
    private List<Copy> copies;
    private Publisher publisher;


    private BookResource() {
    }

    public BookResource(Builder builder) {
        this.resID = builder.resID;
        this.tittle = builder.tittle;
        this.copies = builder.copies;
        this.subject = builder.subject;
        this.ISBN = builder.ISBN;
        this.author = builder.author;
        this.publisher =builder.publisher;
    }

    public Long getResID() {
        return resID;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthors() {
        return author;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public static class Builder{
        private Long resID;
        private String tittle;
        private String subject;
        private String ISBN;
        private Author author;
        private List<Copy> copies;
        private Publisher publisher;


        public Builder(String ISBN){
            this.ISBN = ISBN;
        }

        public Builder resID(Long value){
            this.resID = value;
            return this;
        }
        public Builder tittle(String value){
            this.tittle = value;
            return this;
        }

        public Builder subject(String value){
            this.subject = value;
            return this;
        }

        public Builder publisher(Publisher value){
            this.publisher = value;
            return this;
        }

        public Builder authors(Author value){
            this.author = value;
            return this;
        }

        public Builder copies(List<Copy> value){
            this.copies = value;
            return this;
        }

        public Builder copy(BookResource value){
            this.tittle = value.tittle;
            this.subject = value.subject;
            this.ISBN = value.ISBN;
            this.author = value.author;
            this.publisher = value.publisher;
            this.copies = value.copies;
            return this;
        }

        public BookResource build(){return new BookResource(this);}

    }
}

package za.ac.cput.LibrarySystem.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Branwyn on 2015-05-06.
 */
@MappedSuperclass
public abstract class LibraryItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String tittle;
    protected String subject;


    public String getTittle() {
        return tittle;
    }

    public String getSubject() {
        return subject;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem)) return false;

        LibraryItem item = (LibraryItem) o;

        return !(id != null ? !id.equals(item.id) : item.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}

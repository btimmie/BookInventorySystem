package za.ac.cput.LibrarySystem.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Yongama on 2015-05-19.
 */
public class CopyResource extends ResourceSupport {

    private Long resId;
    private String accessionNumber;
    private String datePurchased;
    private String copy_Notes;
    private CopyResource(){}

    public CopyResource(Builder builder){
        resId = builder.resId;
        accessionNumber = builder.accessionNumber;
        datePurchased = builder.datePurchased;
        copy_Notes = builder.copy_Notes;
    }

    public Long getResId() {
        return resId;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public String getDatePurchased() {
        return datePurchased;
    }

    public String getCopy_Notes() {
        return copy_Notes;
    }


    public static class Builder{
        private Long resId;
        private String accessionNumber;
        private String datePurchased;
        private String copy_Notes;

        public Builder(String accessionNumber){
            this.accessionNumber = accessionNumber;
        }

        public Builder resId(Long value){
            this.resId = value;
            return this;}
        public Builder accessionNumber(String value){
            this.accessionNumber = value;
            return this;
        }

        public Builder datePurchased(String value){
            this.datePurchased = value;
            return this;
        }

        public Builder copy_Notes(String value){
            this.copy_Notes = value;
            return this;
        }

        public Builder copy(CopyResource copy){
            this.accessionNumber = copy.accessionNumber;
            this.datePurchased = copy.datePurchased;
            this.copy_Notes = copy.copy_Notes;
            return this;
        }

        public CopyResource build() {
            return new CopyResource(this);
        }
    }
}

package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;


public class UserStorage {
    private SimpleStringProperty recipient;
    private SimpleStringProperty station;
    private SimpleStringProperty nomination;
    private SimpleStringProperty size;
    private SimpleStringProperty index;
    private SimpleStringProperty dateOfIssue;
    private SimpleStringProperty returnDate;
    private SimpleStringProperty detail;
    private SimpleStringProperty id;


    public UserStorage(String recip, String stat, String nom, String siz, String inde, String dateOfIs, String returnDat, String detai, String id) {

        this.recipient = new SimpleStringProperty(recip);
        this.station = new SimpleStringProperty(stat);
        this.nomination = new SimpleStringProperty(nom);
        this.size = new SimpleStringProperty(siz);
        this.index = new SimpleStringProperty(inde);
        this.dateOfIssue = new SimpleStringProperty(dateOfIs);
        this.returnDate = new SimpleStringProperty(returnDat);
        this.detail = new SimpleStringProperty(detai);
        this.id = new SimpleStringProperty(id);
    }

    public String getRecipient() {
        return recipient.get();
    }

    public void setRecipient(String recipient) {
        this.recipient.set(recipient);
    }

    public String getStation() {
        return station.get();
    }

    public void setStation(String station) {
        this.station.set(station);
    }

    public String getNomination() {
        return nomination.get();
    }

    public void setNomination(String nomination) {
        this.nomination.set(nomination);
    }

    public String getSize() {
        return size.get();
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public String getIndex() {
        return index.get();
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    public String getDateOfIssue() {
        return dateOfIssue.get();
    }

    public void setDateOfIssue(String dateOfIssue) {
       this.dateOfIssue.set(dateOfIssue);
    }

    public String getReturnDate() {
        return returnDate.get();
    }

    public void setReturnDate(String returnDate) {
        this.returnDate.set(returnDate);
    }

    public String getDetail() {
        return detail.get();
    }

    public void setDetail(String detail) {
        this.detail.set(detail);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }
}



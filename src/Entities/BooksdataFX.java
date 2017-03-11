/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BooksdataFX{

    private SimpleIntegerProperty no;
    private SimpleStringProperty id;
    private SimpleStringProperty tittle;
    private SimpleStringProperty publisher;
    private SimpleStringProperty writer;
    private SimpleIntegerProperty year;
    private SimpleIntegerProperty qty;
    private SimpleIntegerProperty status;

    public BooksdataFX() {
    }

    public BooksdataFX(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public BooksdataFX(String id, int no, String tittle, String publisher, String writer, int year, int qty) {
        this.id = new SimpleStringProperty (id);
        this.no = new SimpleIntegerProperty(no);        
        this.tittle = new SimpleStringProperty(tittle);
        this.publisher = new SimpleStringProperty(publisher);
        this.writer = new SimpleStringProperty(writer);
        this.year = new SimpleIntegerProperty(year);
        this.qty = new SimpleIntegerProperty(qty);        
    }

    public int getNo() {
        return no.get();
    }

    public SimpleIntegerProperty getNoProperty(){
        return no;
    }
    
    public void setNo(int no) {
        this.no = new SimpleIntegerProperty(no);
    }

    public String getId() {
        return id.get();
    }
    
    public SimpleStringProperty getIdProperty() {
        return id;
    }

    public void setid(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public String getTittle() {
        return tittle.get();
    }
    
    public SimpleStringProperty getTittleProperty() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = new SimpleStringProperty(tittle);
    }

    public String getPublisher() {
        return publisher.get();
    }
    
    public SimpleStringProperty getPublisherProperty() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = new SimpleStringProperty(publisher);
    }

    public String getWriter() {
        return writer.get();
    }
    
    public SimpleStringProperty getWriterProperty() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = new SimpleStringProperty(writer);
    }

    public int getYear() {
        return year.get();
    }
    
    public SimpleIntegerProperty getYearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year = new SimpleIntegerProperty(year);
    }

    public int getQty() {
        return qty.get();
    }
    
    public SimpleIntegerProperty getQtyProperty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = new SimpleIntegerProperty(qty);
    }
}

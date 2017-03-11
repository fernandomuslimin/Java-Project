/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Fernando M 
 */
@Entity
@Table(name = "booksdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booksdata.findAll", query = "SELECT b FROM Booksdata b ORDER BY b.no ASC"),
    @NamedQuery(name = "Booksdata.findByNo", query = "SELECT b FROM Booksdata b WHERE b.no = :no"),
    @NamedQuery(name = "Booksdata.findById", query = "SELECT b FROM Booksdata b WHERE b.id = :id"),
    @NamedQuery(name = "Booksdata.findByTittle", query = "SELECT b FROM Booksdata b WHERE b.tittle LIKE :tittle ORDER BY b.no ASC"),
    @NamedQuery(name = "Booksdata.findByPublisher", query = "SELECT b FROM Booksdata b WHERE b.publisher LIKE :publisher ORDER BY b.no ASC"),
    @NamedQuery(name = "Booksdata.findByWriter", query = "SELECT b FROM Booksdata b WHERE b.writer LIKE :writer ORDER BY b.no ASC"),
    @NamedQuery(name = "Booksdata.findByYear", query = "SELECT b FROM Booksdata b WHERE b.year = :year"),
    @NamedQuery(name = "Booksdata.findByQty", query = "SELECT b FROM Booksdata b WHERE b.qty = :qty")})
public class Booksdata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "no")
    private int no;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "tittle")
    private String tittle;
    @Basic(optional = false)
    @Column(name = "publisher")
    private String publisher;
    @Basic(optional = false)
    @Column(name = "writer")
    private String writer;
    @Basic(optional = false)
    @Column(name = "year")
    private int year;
    @Basic(optional = false)
    @Column(name = "qty")
    private int qty;    

    public Booksdata() {
    }

    public Booksdata(String id) {
        this.id = id;
    }

    public Booksdata(String id, int no, String tittle, String publisher, String writer, int year, int qty) {
        this.id = id;
        this.no = no;        
        this.tittle = tittle;
        this.publisher = publisher;
        this.writer = writer;
        this.year = year;
        this.qty = qty;       
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booksdata)) {
            return false;
        }
        Booksdata other = (Booksdata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Booksdata[ id=" + id + " ]";
    }

}

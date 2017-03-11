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
@Table(name = "penyewa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penyewa.findAll", query = "SELECT p FROM Penyewa p"),
    @NamedQuery(name = "Penyewa.findByNo", query = "SELECT p FROM Penyewa p WHERE p.no = :no"),
    @NamedQuery(name = "Penyewa.findByNama", query = "SELECT p FROM Penyewa p WHERE p.nama = :nama"),
    @NamedQuery(name = "Penyewa.findById", query = "SELECT p FROM Penyewa p WHERE p.id = :id"),
    @NamedQuery(name = "Penyewa.findByAlamat", query = "SELECT p FROM Penyewa p WHERE p.alamat = :alamat"),
    @NamedQuery(name = "Penyewa.findByTtl", query = "SELECT p FROM Penyewa p WHERE p.ttl = :ttl"),
    @NamedQuery(name = "Penyewa.findByInstansi", query = "SELECT p FROM Penyewa p WHERE p.instansi = :instansi")})
public class Penyewa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "no")
    private int no;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @Column(name = "ttl")
    private String ttl;
    @Basic(optional = false)
    @Column(name = "instansi")
    private String instansi;

    public Penyewa() {
    }

    public Penyewa(String id) {
        this.id = id;
    }

    public Penyewa(String id, int no, String nama, String alamat, String ttl, String instansi) {
        this.id = id;
        this.no = no;
        this.nama = nama;
        this.alamat = alamat;
        this.ttl = ttl;
        this.instansi = instansi;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
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
        if (!(object instanceof Penyewa)) {
            return false;
        }
        Penyewa other = (Penyewa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Penyewa[ id=" + id + " ]";
    }

}

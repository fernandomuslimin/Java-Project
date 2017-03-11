/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PenyewaFX implements Serializable {

    private SimpleIntegerProperty no;
    private SimpleStringProperty nama;
    private SimpleStringProperty id;
    private SimpleStringProperty alamat;
    private SimpleStringProperty ttl;
    private SimpleStringProperty instansi;

    public PenyewaFX() {
    }

    public PenyewaFX(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public PenyewaFX(String id, int no, String nama, String alamat, String ttl, String instansi) {
        this.id = new SimpleStringProperty(id);
        this.no = new SimpleIntegerProperty(no);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.ttl = new SimpleStringProperty(ttl);
        this.instansi = new SimpleStringProperty(instansi);
    }

    public int getNo() {
        return no.get();
    }

    public SimpleIntegerProperty getNoProperty() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = new SimpleIntegerProperty(no);
    }

    public String getNama() {
        return nama.get();
    }
    
    public SimpleStringProperty getNamaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = new SimpleStringProperty(nama);
    }

    public String getId() {
        return id.get();
    }
    
    public SimpleStringProperty getIdProperty() {
        return id;
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public String getAlamat() {
        return alamat.get();
    }
    
    public SimpleStringProperty getAlamatProperty() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = new SimpleStringProperty(alamat);
    }

    public String getTtl() {
        return ttl.get();
    }
    
    public SimpleStringProperty getTtlProperty() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = new SimpleStringProperty(ttl);
    }

    public String getInstansi() {
        return instansi.get();
    }
    
    public SimpleStringProperty getInstansiProperty() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = new SimpleStringProperty(instansi);
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
        if (!(object instanceof PenyewaFX)) {
            return false;
        }
        PenyewaFX other = (PenyewaFX) object;
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

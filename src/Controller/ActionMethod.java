/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Database.DBConnection;
import Entities.Booksdata;
import Entities.BooksdataFX;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import librarysystem.Main;

/**
 * 
 * @author Fernando M 
 */
public class ActionMethod {
    Connection con;
    Statement st;
    ResultSet rs;
    UIControll uic = new UIControll();
    
    public void Login(String username, String password){
        
        try {
            String sql = "SELECT username,password FROM adminid WHERE username = '"+username+"' AND password = '"+password+"'";
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Your Login Success.");
                uic.CallUI("/librarysystem/Home.fxml");
            }else{
                JOptionPane.showMessageDialog(null, "Username/Password Is Not Registered In Database");
            }
        } catch (SQLException | HeadlessException e) {
            e.getCause();
        }
    }
        
    public void buildDataTable(TableView tblBooks, String namedQuery, TableColumn<BooksdataFX,String> id, TableColumn<BooksdataFX,Number> no, TableColumn<BooksdataFX,String> tittle, TableColumn<BooksdataFX,String> publisher, TableColumn<BooksdataFX,String> writer, TableColumn<BooksdataFX,Number> year, TableColumn<BooksdataFX,Number> qty, TableColumn<BooksdataFX,Number> status){
        EntityManager em;
        ObservableList<BooksdataFX> data;
        
        try {            
            em = Main.emf.createEntityManager();
            
            List<Booksdata> bookList = (List<Booksdata>) em.createNamedQuery(namedQuery).getResultList();
            data = FXCollections.observableArrayList();
            
            bookList.stream().forEach((bookListCopy) -> {
                data.add(new BooksdataFX(bookListCopy.getId(), bookListCopy.getNo(), bookListCopy.getTittle(), bookListCopy.getPublisher(), bookListCopy.getWriter(), bookListCopy.getYear(), bookListCopy.getQty()));
            });           
            
            
            tblBooks.setItems(data);
            tblBooks.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            
            id.setCellValueFactory(cell->cell.getValue().getIdProperty());
            no.setCellValueFactory(cell->cell.getValue().getNoProperty());           
            tittle.setCellValueFactory(cell->cell.getValue().getTittleProperty());
            publisher.setCellValueFactory(cell->cell.getValue().getPublisherProperty());
            writer.setCellValueFactory(cell->cell.getValue().getWriterProperty());
            year.setCellValueFactory(cell->cell.getValue().getYearProperty());
            qty.setCellValueFactory(cell->cell.getValue().getQtyProperty());
            
            
        } catch (Exception e) {
            e.getCause();
        }
    }
    
    public void insertBooksQuery(String id, String tittle, String publisher, String writer, int year, int qty){
        String sql = "INSERT INTO booksdata(id,tittle,publisher,writer,year,qty) VALUES ('"+id+"','"+tittle+"','"+publisher+"','"+writer+"','"+year+"','"+qty+"')";
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Added Successfully");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Saving Data Failed!");
            e.printStackTrace();
        }
    }
    
    public void searchByQueries(TableView tblBooks, String namedQuery, String param, String value, TableColumn<BooksdataFX,String> id, TableColumn<BooksdataFX,Number> no, TableColumn<BooksdataFX,String> tittle, TableColumn<BooksdataFX,String> publisher, TableColumn<BooksdataFX,String> writer, TableColumn<BooksdataFX,Number> year, TableColumn<BooksdataFX,Number> qty, TableColumn<BooksdataFX,Number> status){
        EntityManager em;
        ObservableList<BooksdataFX> data;
        
        try {            
            em = Main.emf.createEntityManager();
            
            List<Booksdata> bookList = (List<Booksdata>) em.createNamedQuery(namedQuery).setParameter(param, value).getResultList();
            data = FXCollections.observableArrayList();
            
            bookList.stream().forEach((bookListCopy) -> {
                data.add(new BooksdataFX(bookListCopy.getId(), bookListCopy.getNo(), bookListCopy.getTittle(), bookListCopy.getPublisher(), bookListCopy.getWriter(), bookListCopy.getYear(), bookListCopy.getQty()));
            });           
            
            
            tblBooks.setItems(data);
            tblBooks.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            
            id.setCellValueFactory(cell->cell.getValue().getIdProperty());
            no.setCellValueFactory(cell->cell.getValue().getNoProperty());           
            tittle.setCellValueFactory(cell->cell.getValue().getTittleProperty());
            publisher.setCellValueFactory(cell->cell.getValue().getPublisherProperty());
            writer.setCellValueFactory(cell->cell.getValue().getWriterProperty());
            year.setCellValueFactory(cell->cell.getValue().getYearProperty());
            qty.setCellValueFactory(cell->cell.getValue().getQtyProperty());
            
            
        } catch (Exception e) {
            e.getCause();
        }
    }
}

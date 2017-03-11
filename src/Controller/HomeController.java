/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.BooksdataFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Fernando M
 */
public class HomeController implements Initializable {

    @FXML
    private TableView<BooksdataFX> tblBooks;
    @FXML
    private TableColumn<BooksdataFX, Number> no;
    @FXML
    private TableColumn<BooksdataFX, String> id;
    @FXML
    private TableColumn<BooksdataFX, String> tittle;
    @FXML
    private TableColumn<BooksdataFX, String> publisher;
    @FXML
    private TableColumn<BooksdataFX, String> writer;
    @FXML
    private TableColumn<BooksdataFX, Number> year;
    @FXML
    private TableColumn<BooksdataFX, Number> qty;
    @FXML
    private TableColumn<BooksdataFX, Number> status;
    @FXML
    private TextField fSearchby;
    EntityManager em;
    ObservableList<BooksdataFX> data;
    ObservableList comboSearchItems;
    @FXML
    private ComboBox<?> comboSearchBy;
    ActionMethod am = new ActionMethod();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buildDataTable();
        comboSearchItems();
        fSearchby.setDisable(true);
    }       
    
    public void buildDataTable(){        
        am.buildDataTable(tblBooks, "Booksdata.findAll", id, no, tittle, publisher, writer, year, qty, status);
    }

    @FXML
    private void SearchBy(ActionEvent event) {        
       fSearchby.setDisable(false);        
    }
    
    private void comboSearchItems(){
        comboSearchItems = FXCollections.observableArrayList(
                    "Book Tittle",
                    "Publisher",
                    "Writer"
                );
        comboSearchBy.setItems(comboSearchItems);
    }

    @FXML
    private void SearcAction(ActionEvent event) {
         if(comboSearchBy.getSelectionModel().getSelectedItem() == "Book Tittle"){            
            am.searchByQueries(tblBooks, "Booksdata.findByTittle", "tittle", "%"+fSearchby.getText()+"%", id, no, tittle, publisher, writer, year, qty, status);
        }else if(comboSearchBy.getSelectionModel().getSelectedItem() == "Publisher"){            
            am.searchByQueries(tblBooks, "Booksdata.findByPublisher","publisher", "%"+fSearchby.getText()+"%", id, no, tittle, publisher, writer, year, qty, status);
        }else if(comboSearchBy.getSelectionModel().getSelectedItem() == "Writer"){            
            am.searchByQueries(tblBooks, "Booksdata.findByWriter", "writer", "%"+fSearchby.getText()+"%", id, no, tittle, publisher, writer, year, qty, status);
        }
         System.out.println("test");
    }

    @FXML
    private void newBorrow(ActionEvent event) {
        UIControll uic = new UIControll();
        uic.CallUI("/librarysystem/AddNewBooks.fxml");
    }

    @FXML
    private void RefreshTable(ActionEvent event) {
        am.buildDataTable(tblBooks, "Booksdata.findAll", id, no, tittle, publisher, writer, year, qty, status);
    }

    @FXML
    private void BookList(ActionEvent event) {
        am.buildDataTable(tblBooks, "Booksdata.findAll", id, no, tittle, publisher, writer, year, qty, status);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static libary.Libary.writeLog;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class BooksController implements Initializable {
    private Books s;
    private final EntityManagerFactory emf =  Persistence.createEntityManagerFactory("LibaryPU");
    private final EntityManager em =
                 emf.createEntityManager();

    @FXML
    private VBox vbox1;
    @FXML
    private HBox hbox1;
    @FXML
    private TableView<Books> tv;
    @FXML
    private TableColumn<Books, Integer> tc1;
    @FXML
    private TableColumn<Books, String> tc2;
    @FXML
    private TableColumn<Books, String> tc3;
    @FXML
    private VBox vbox2;
    @FXML
    private Label labelID;
    @FXML
    private TextField tfID;
    @FXML
    private Label labelName;
    @FXML
    private TextField tfName;
    @FXML
    private Label labelPass;
    @FXML
    private HBox hbox2;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private TextField tfDesc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tc1.setCellValueFactory( new PropertyValueFactory("id"));
        tc2.setCellValueFactory( new PropertyValueFactory("name"));
        tc3.setCellValueFactory( new PropertyValueFactory("descreption"));
        try {
            show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }    

    @FXML
    private void addHandle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        int i = Integer.parseInt(tfID.getText());
         String n = tfName.getText();
         String p = tfDesc.getText();
         Books s1 = new Books( );
         s1.setId(i);
         s1.setName(n);
         s1.setDescreption(p);
         
         
         em.getTransaction().begin();
        em.persist(s1);
        em.getTransaction().commit();
        show();
         writeLog("Book added to the database");
    }

    @FXML
    private void delAction(ActionEvent event) {
        Books s1 = tv.getSelectionModel().getSelectedItem();
        if (s1 != null) {
        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        
        s1 = em.merge(s1);//should be merged
        
        em.remove(s1);
        em.getTransaction().commit();
        em.close();
        }
        show();
         writeLog("Book deleted");
    }

    @FXML
    private void upAction(ActionEvent event) throws Exception{
         Parent view2 = FXMLLoader.load(getClass().
                getResource("editBook.fxml"));
           Scene s2 = new Scene(view2);
           Stage window = new Stage();
           window.setScene(s2);
           window.show();
            writeLog("Book updated");
    }
    public  void show (){
        
         List<Books> st = em.createNamedQuery("Books.findAll").getResultList();
         tv.getItems().setAll(st);
    }
    
}

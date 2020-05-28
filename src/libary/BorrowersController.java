/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.io.IOException;
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
public class BorrowersController implements Initializable {
private Borrowers s;
    private final EntityManagerFactory emf =  Persistence.createEntityManagerFactory("LibaryPU");
    private final EntityManager em =
                 emf.createEntityManager();

    @FXML
    private VBox vbox1;
    @FXML
    private HBox hbox1;
    @FXML
    private TableView<Borrowers> tv;
    @FXML
    private TableColumn<Borrowers, Integer> tc1;
    @FXML
    private TableColumn<Borrowers, String> tc2;
    @FXML
    private TableColumn<Borrowers, String> tc3;
    @FXML
    private TableColumn<Borrowers, Integer> tc31;
    @FXML
    private TableColumn<Borrowers, String> tc311;
    @FXML
    private TableColumn<Borrowers, String> tc32;
    @FXML
    private VBox vbox2;
    @FXML
    private Label labelID;
    @FXML
    private TextField tfID;
    @FXML
    private Label labelName;
    @FXML
    private TextField tffn;
    @FXML
    private Label labelPass;
    @FXML
    private TextField tfln;
    @FXML
    private Label labelPass1;
    @FXML
    private TextField tfmobile;
    @FXML
    private Label labelName1;
    @FXML
    private TextField tfemail;
    @FXML
    private Label labelID1;
    @FXML
    private TextField tfaddress;
    @FXML
    private HBox hbox2;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
            show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        tc1.setCellValueFactory( new PropertyValueFactory("id"));
        tc2.setCellValueFactory( new PropertyValueFactory("fn"));
        tc3.setCellValueFactory( new PropertyValueFactory("ln")); 
        
        tc31.setCellValueFactory( new PropertyValueFactory("mobile"));
        tc311.setCellValueFactory( new PropertyValueFactory("email"));
        tc32.setCellValueFactory( new PropertyValueFactory("address"));
    }    
     public  void show (){
        
         List<Borrowers> st = em.createNamedQuery("Borrowers.findAll").getResultList();
         tv.getItems().setAll(st);
    }

    @FXML
    private void addHandle(ActionEvent event) {
        
        int i = Integer.parseInt(tfID.getText());
         String n = tffn.getText();
         String p = tfln.getText();
         int mn = Integer.parseInt(tfmobile.getText());
         String email = tfemail.getText();
         String ad = tfaddress.getText();
        
         Borrowers s1 = new Borrowers( );
         s1.setId(i);
         s1.setFn(n);
         s1.setLn(p);
         s1.setMobile(mn);
         s1.setEmail(email);
         s1.setAddress(ad);
         
         em.getTransaction().begin();
          writeLog("Borrower added");
        
        
        
        
        em.persist(s1);
        em.getTransaction().commit();
        show();
    }

    @FXML
    private void delAction(ActionEvent event) {
        Borrowers s1 = tv.getSelectionModel().getSelectedItem();
        if (s1 != null) {
        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        
        s1 = em.merge(s1);//should be merged
        
        em.remove(s1);
        em.getTransaction().commit();
        em.close();
        }
        show();
         writeLog("Borrower Deleted");
    }

    @FXML
    private void upAction(ActionEvent event) throws IOException{
         Parent view2 = FXMLLoader.load(getClass().
                getResource("editBorrowers.fxml"));
           Scene s2 = new Scene(view2);
           Stage window = new Stage();
           window.setScene(s2);
           window.show();
            writeLog("Borrower updated");
    }
    
}

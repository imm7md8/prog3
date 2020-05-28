/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class UController implements Initializable {
private Users s;
    private  EntityManagerFactory emf =
            Persistence.createEntityManagerFactory
        ("LibaryPU");
    private final EntityManager em =
                 emf.createEntityManager();


    @FXML
    private VBox vbox1;
    @FXML
    private HBox hbox1;
    @FXML
    private TableView<Users> tv;
    @FXML
    private TableColumn<Users, Integer> tc1;
    @FXML
    private TableColumn<Users, String> tc2;
    @FXML
    private TableColumn<Users, String> tc3;
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
    private TextField tfDesc;
    @FXML
    private HBox hbox2;
    @FXML
    private Button add;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    String select_ = "Select * from books";
    ResultSet rs = null;
    @FXML
    private Label labelPass;
    @FXML
    private TextField tfPass;
    @FXML
    private Button update;
    @FXML
    private Button btnShow;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        tc1.setCellValueFactory( new PropertyValueFactory("id"));
        tc2.setCellValueFactory( new PropertyValueFactory("name"));
        tc3.setCellValueFactory( new PropertyValueFactory("password"));
    }    
@FXML
     public void addHandle(ActionEvent event) throws  IOException {
         int i = Integer.parseInt(tfID.getText());
         String n = tfName.getText();
         String p = tfPass.getText();
         p.hashCode();
         Users s1 = new Users( );
         s1.setId(i);
         s1.setName(n);
         s1.setPassword(p);
         
         em.getTransaction().begin();
        
        
        
        
        em.persist(s1);
        em.getTransaction().commit();
        show();
          writeLog("User added");
       } 
      public  void show (){
        
         List<Users> st = em.createNamedQuery("Users.findAll").getResultList();
         tv.getItems().setAll(st);
    }

    @FXML
    private void delAction(ActionEvent event) {
        Users s1 = tv.getSelectionModel().getSelectedItem();
        if (s1 != null) {
        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        
        s1 = em.merge(s1);//should be merged
        
        em.remove(s1);
        em.getTransaction().commit();
        em.close();
        }
        show();
         writeLog("User deleted");
    
    }

    @FXML
    private void upAction(ActionEvent event) throws Exception{
        Parent view2 = FXMLLoader.load(getClass().
                getResource("addUser.fxml"));
           Scene s2 = new Scene(view2);
           Stage window = new Stage();
           window.setScene(s2);
           window.show();
            writeLog("User updated");
    }

    @FXML
    private void ShowHandle(ActionEvent event) {
        show();
    }
    
}
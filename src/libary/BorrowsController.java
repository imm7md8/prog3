/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static libary.Libary.writeLog;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class BorrowsController implements Initializable {
private BorrowersBooks s;
private BorrowersBooksPK s1;


    private final EntityManagerFactory emf =  Persistence.createEntityManagerFactory("LibaryPU");
    private final EntityManager em =
                 emf.createEntityManager();
    @FXML
    private VBox vbox1;
    @FXML
    private HBox hbox1;
    @FXML
    private TableView<BorrowersBooks> tv;
    @FXML
    private TableColumn<BorrowersBooks, Integer> tc1;
    @FXML
    private TableColumn<BorrowersBooks, Integer> tc2;
    @FXML
    private TableColumn<BorrowersBooks, String> tc3;
    @FXML
    private VBox vbox2;
    @FXML
    private Label labelID;
    @FXML
    private TextField tfbid;
    @FXML
    private Label labelName;
    @FXML
    private TextField tfbrid;
    @FXML
    private Label labelPass;
    @FXML
    private DatePicker tfdate;
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
         tc1.setCellValueFactory( new PropertyValueFactory("bookId"));
        tc2.setCellValueFactory( new PropertyValueFactory("borrowerId"));
        tc3.setCellValueFactory( new PropertyValueFactory("borrowDate"));
        try {
            show();
//            List l = bid();
//        System.out.println(l.get(0));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }    

    @FXML
    private void addHandle(ActionEvent event) {
        
         int i = Integer.parseInt(tfbid.getText());
         int n = Integer.parseInt(tfbrid.getText());

        
         BorrowersBooks s1 = new BorrowersBooks( );
        s1.getBooks().setId(i);
        s1.getBorrowers().setId(n);
         s1.setBorrowDate(Date.valueOf(tfdate.getValue()));
         
         em.getTransaction().begin();
        
        
        
        
        em.persist(s1);
        em.getTransaction().commit();
        show();
        writeLog("Borrower added");

    }

    @FXML
    private void delAction(ActionEvent event) {
        BorrowersBooks s1 = tv.getSelectionModel().getSelectedItem();
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

    
     public  void show (){
        
         List<BorrowersBooks> st = em.createNamedQuery("BorrowersBooks.findAll").getResultList();
         tv.getItems().setAll(st);
    }

    @FXML
    private void upAction(ActionEvent event) {
    }
   
}

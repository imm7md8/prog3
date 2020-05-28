/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EditBorrowersController implements Initializable {
    private Books s;
    private final EntityManagerFactory emf =  Persistence.createEntityManagerFactory("LibaryPU");
    private final EntityManager em =
                 emf.createEntityManager();

    @FXML
    private Label lID;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tffn;
    @FXML
    private TextField tfln;
    @FXML
    private Label lID1;
    @FXML
    private Button update;
    @FXML
    private TextField tfmobile;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfaddress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void editAction(ActionEvent event) {
        Borrowers s = new  Borrowers();
        s.setId(Integer.parseInt(tfid.getText()));
        s.setFn(tffn.getText());
        s.setLn(tfln.getText());
        s.setMobile(Integer.parseInt(tfmobile.getText()));
        s.setEmail(tfemail.getText());
        s.setAddress(tfaddress.getText());
        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
        em.close();
        
        tfid.setText("");
        tffn.setText("");
        tfln.setText("");
        tfmobile.setText("");
        tfemail.setText("");
        tfaddress.setText("");
    }

    @FXML
    private void textACtion(ActionEvent event) {
    }

    @FXML
    private void tfphone(ActionEvent event) {
    }

    @FXML
    private void tfemail(ActionEvent event) {
    }

    @FXML
    private void tfaddress(ActionEvent event) {
    }
    
}

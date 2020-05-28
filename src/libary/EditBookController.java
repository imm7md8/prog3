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
public class EditBookController implements Initializable {
    private Books s;
    private final EntityManagerFactory emf =  Persistence.createEntityManagerFactory("LibaryPU");
    private final EntityManager em =
                 emf.createEntityManager();

    @FXML
    private Label lID;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfName;
    @FXML
    private Button btnEdit;
    @FXML
    private TextField tfP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void textACtion(ActionEvent event) {
    }

    @FXML
    private void editAction(ActionEvent event) {
         Books s1 = new Books();
        
        s1.setId(Integer.parseInt(tfID.getText()));
        s1.setName(tfName.getText());
        s1.setDescreption(tfP.getText());
        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(s1);
        em.getTransaction().commit();
        em.close();
        
        tfID.setText("");
        tfName.setText("");
        tfP.setText("");
    }
    
}

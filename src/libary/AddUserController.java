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
import javafx.scene.text.Text;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static libary.Libary.writeLog;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddUserController implements Initializable {
      private Users s;
    private final EntityManagerFactory emf =  Persistence.createEntityManagerFactory("LibaryPU");
    private final EntityManager em =
                 emf.createEntityManager();

    @FXML
    private Label lID;
    @FXML
    private TextField tfID;
    private Text nameDisplay;
    @FXML
    private TextField tfPass;
    @FXML
    private Button btnEdit;
    @FXML
    private TextField tfName;
   

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    @FXML
    private void editAction(ActionEvent event) {
      Users s = new Users();
        
        s.setId(Integer.parseInt(tfID.getText()));
        s.setName(tfName.getText());
        s.setPassword(tfPass.getText());
        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
        em.close();
        
        tfID.setText("");
        tfName.setText("");
        tfPass.setText("");
         writeLog("User edited");
    }

    @FXML
    private void textACtion(ActionEvent event) {
    }
    
}

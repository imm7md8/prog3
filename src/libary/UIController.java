/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UIController implements Initializable {

    @FXML
    private VBox container;
    @FXML
    private AnchorPane cont;
    @FXML
    private GridPane gp1;
    @FXML
    private Button usersBtn;
    
    
    
    @FXML
    private Button borrowersBtn;
    @FXML
    private Button booksBtn;
    @FXML
    private Button borrBookBtn;
    @FXML
    private Label msg1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       msg1.setText("Hello ! \n"
               + "please choose the table you want to modify");
       usersBtn.setText("Users");
       booksBtn.setText("Books");
       borrowersBtn.setText("Borrowers");
       borrBookBtn.setText("Borrows");
      
       
    }  
    
    @FXML
     public void UsersScene(ActionEvent event) throws  IOException {
           Parent view2 = FXMLLoader.load(getClass().getResource("users.fxml"));
           Scene s2 = new Scene(view2);
           Stage window = new Stage();
           window.setScene(s2);
           window.show();
       }
     
    @FXML
     public void BookScene(ActionEvent event) throws  IOException {
           Parent view2 = FXMLLoader.load(getClass().getResource("books.fxml"));
           Scene s2 = new Scene(view2);
           Stage window = new Stage();
           window.setScene(s2);
           window.show();
       }
     
    @FXML
     public void BorrowersScene(ActionEvent event) throws  IOException {
           Parent view2 = FXMLLoader.load(getClass().getResource("borrowers.fxml"));
           Scene s2 = new Scene(view2);
           Stage window = new Stage();
           window.setScene(s2);
           window.show();
       }
     
    @FXML
     public void BorrowsScene(ActionEvent event) throws  IOException {
           Parent view2 = FXMLLoader.load(getClass().getResource("borrows.fxml"));
           Scene s2 = new Scene(view2);
           Stage window = new Stage();
           window.setScene(s2);
           window.show();
       }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Libary  extends Application {
    
        public static File logFile = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\Libary\\src\\libary\\log.txt");
        public static void writeLog(String txt){
    try {
            if(!logFile.exists()){
                    logFile.createNewFile();
                }
            String time = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss").format(Calendar.getInstance().getTime());
            FileWriter writer = new FileWriter(logFile,true);
            PrintWriter pw = new PrintWriter(writer);
            pw.println(txt+" : At time : "+time+" *****EndOfLine.");
            pw.close();
            writer.close();      
        } catch (IOException ex) {
            System.out.println("Error !");
        }
        
    }
        
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane root = new StackPane();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("FXML.fxml")));
        writeLog("Program started");
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

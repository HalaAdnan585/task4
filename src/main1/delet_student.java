/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
class delet_student {
    private Statement stmt;
  private TextField StudentName = new TextField();
  private Button delet = new Button("DELET");
  private Label lblStatus = new Label();
  private Label lblStatus2 = new Label();
    Stage stage= new Stage();

   String queryString = " ";
  
    public void start(Stage primaryStage) {
    // Create UI
    initializeDB();
    
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("STUDENT NAME"), 0, 0);
 
    
    gridPane.add(StudentName , 1, 0);
  
    
      gridPane.add(delet , 6, 5);
      gridPane.add(lblStatus, 1, 8);
      gridPane.add(lblStatus2, 1, 8);
    
    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    

    // Process events
   delet.setOnAction(e -> Delet_Student());
    
    Pane headpane = new StackPane();
    Text head = new Text("DELET STUDENT"); 
    headpane.getChildren().add(head);
    HBox hBox = new HBox();
    hBox.setSpacing(20);
    hBox.setAlignment(Pos.CENTER);
    
     hBox.getChildren().add(new Label("       "));

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(hBox);
    
    
    borderPane.setTop(headpane);
    BorderPane.setAlignment(hBox, Pos.CENTER);
    
    
    // Create a scene and place it in the stage
   Scene scene = new Scene(borderPane, 600, 250);
     stage.setResizable(false);
   // primaryStage.setTitle("Learn Math"); // Set title
    stage.setScene(scene); // Place the scene in the stage
    stage.show(); // Display the stage
  }
    
private void initializeDB() {
        
     Connection con=null;
     ResultSet rs=null;
     PreparedStatement pd=null;
     String user="root";
     String password="123456789";
     String conn="jdbc:mysql://localhost:3306/library?verifyServerCertificate=false&useSSL=true";
    
       try {
             con=DriverManager.getConnection(conn,user,password);
           stmt= con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }// initializeDB
    
   private void Delet_Student() {
       
    String student_name = StudentName .getText();
  //DELETE FROM Persons WHERE Person_Id = 103
        
    try {
        
        if(student_name!=""){
            
            ResultSet rset = stmt.executeQuery("SELECT * FROM students WHERE sname='"+student_name+"'");
            if( rset.next() ==false ){
                JOptionPane.showMessageDialog(null,"الأسم غير موجود"); 
            }else{
                ResultSet rset2 = stmt.executeQuery("SELECT * FROM borrow WHERE borrow_name='"+student_name+"' and flag='1'");
                if(rset2.next()){
                    JOptionPane.showMessageDialog(null,"لا يمكن حذف الطالب ");
                }else{
                    JOptionPane.showMessageDialog(null,"تم حذف الطالب");
                    stmt.executeUpdate("DELETE FROM `students` WHERE sname='"+student_name+"'");   
                }
            }
                
            
        }else{
            JOptionPane.showMessageDialog(null,"يجب ملئ كل الحقول");    
        }
        
       
        
    }catch (SQLException ex) {
        ex.printStackTrace();
    }
    
  }//addBook
     
}

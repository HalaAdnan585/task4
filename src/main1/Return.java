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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
class Return {
   HBox hbox2 = new HBox(50);
   HBox hbox5 = new HBox(50);
   HBox hbox6 = new HBox(50);
    
   Button button26 = new Button("Student");
   Button button27 = new Button("Professor");
   Button ptn_student_return = new Button("return");
   Button ptn_prof_return = new Button("return");
    
    VBox vBox13 = new VBox(10);
    VBox vBox9 = new VBox(10);
    VBox vBox16 = new VBox(10);
    VBox vBox17 = new VBox(10);
    VBox vBox18 = new VBox(10);

    Text t15 = new Text("Student Name");
    Text t16 = new Text("Professor Name");
      
     TextField txt_field_student = new TextField();
    TextField txt_field_prof = new TextField();  
    
    private ComboBox <String> book_list = new ComboBox<>();
    private Statement stmt;
    Connection conn;
    
     public void start(Stage primaryStage) throws SQLException {
         initializeDB();
         hbox2.getChildren().addAll(button26,button27);
      hbox2.setAlignment(Pos.CENTER);
      
      vBox9.getChildren().addAll(hbox2);
      vBox9.setStyle("-fx-border-color: black;"
                 + "-fx-background-color: GREEN");
      vBox9.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      vBox18.getChildren().addAll(vBox16,vBox17);
      
      BorderPane pane = new BorderPane();
         pane.setTop(vBox9); 
         pane.setCenter(vBox18);
         
         book_list.setValue("return Books");
         String sql="select * from book where flag = 1  ";
         ResultSet rset4 = stmt.executeQuery(sql);
         while(rset4.next()){
         String title = rset4.getString("title");
         String books = title ;
         book_list.getItems().addAll(books);
         }
        // pane.setCenter(vBox11);
        
       // button26.setOnAction(e -> BStudent());
        //button27.setOnAction(e -> BProfessor());
        
         button26.setOnAction(e -> {
             try {
                 RStudent();
             } catch (SQLException ex) {
                 Logger.getLogger(Return.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
        button27.setOnAction(e -> RProfessor());
        
         ptn_student_return.setOnAction(e -> {
           try {
               Return_Student();
           } catch (SQLException ex) {
               Logger.getLogger(borrow.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
         
         ptn_prof_return.setOnAction(e -> {
           try {
               Return_prof();
           } catch (SQLException ex) {
               Logger.getLogger(borrow.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
      
     Stage stage = new Stage(); // Create a new stage
    stage.setTitle("Second Stage"); // Set the stage title
    // Set a scene with a button in the stage
    stage.setScene(new Scene(pane, 550, 200));        
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
    
     private void RStudent() throws SQLException{
         
         
      hbox5.getChildren().addAll(t15,txt_field_student, book_list,ptn_student_return);
      hbox5.setAlignment(Pos.CENTER);
      hbox5.setStyle("-fx-size: 10");
      vBox16.setStyle("-fx-border-color: black");
      vBox16.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      vBox16.getChildren().addAll(hbox5);
      vBox13.getChildren().addAll(hbox6); 
      vBox13.getChildren().clear(); 
      vBox13.getChildren().addAll(hbox6);
}
      private void Return_Student() throws SQLException{
       
          String student_name= txt_field_student.getText();
        String book_name = book_list.getValue();
        
        ResultSet rset = stmt.executeQuery("SELECT * FROM borrow where borrow_name='"+student_name+"' and book_name='"+book_name+"'");
        
        if(student_name!="" && book_name!="return Books"){
         
            if(rset.next() == true){

                ResultSet rset2 = stmt.executeQuery("SELECT * FROM borrow where borrow_name='"+student_name+"' and book_name='"+book_name+"' and flag='0'");

                if(rset2.next() == false){
                    
                    stmt.executeUpdate("UPDATE book SET flag = 0 WHERE title='"+book_name+"'"); 
                    stmt.executeUpdate("UPDATE borrow SET flag = 0 WHERE borrow_name='"+student_name+"' and book_name='"+book_name+"'");    
                    JOptionPane.showMessageDialog(null,"تم أسترجاع الكتاب");
                    
                }else{
                        JOptionPane.showMessageDialog(null,"لقد تم أسترجاع هذا الكتاب مسبقا");
                }


            }else{
               JOptionPane.showMessageDialog(null,"لم يتم أستقراض هذا الكتاب مسبقا"); 
            }
//        
        }else{
               JOptionPane.showMessageDialog(null,"لا يجب ترك احد الحقول فارغا"); 
        }
//      
          
          
      
        
          
      }

private void RProfessor(){
      hbox6.getChildren().addAll(t16,txt_field_prof, book_list,ptn_prof_return);
      hbox6.setAlignment(Pos.CENTER);
      hbox6.setStyle("-fx-size: 10");
      vBox17.getChildren().addAll(hbox6);
      vBox17.setStyle("-fx-border-color: black");
      vBox17.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      vBox13.getChildren().addAll(vBox16); 
      vBox13.getChildren().clear(); 
      vBox13.getChildren().addAll(vBox16); 
         
}

private void Return_prof() throws SQLException {
   String prof_name= txt_field_prof.getText();
        String book_name = book_list.getValue();
        
        ResultSet rset = stmt.executeQuery("SELECT * FROM borrow where borrow_name='"+prof_name+"' and book_name='"+book_name+"'");
        
        if(prof_name!="" && book_name!="return Books"){
         
            if(rset.next() == true){

                ResultSet rset2 = stmt.executeQuery("SELECT * FROM borrow where borrow_name='"+prof_name+"' and book_name='"+book_name+"' and flag='0'");

                if(rset2.next() == false){
                    
                    stmt.executeUpdate("UPDATE book SET flag = 0 WHERE title='"+book_name+"'"); 
                    stmt.executeUpdate("UPDATE borrow SET flag = 0 WHERE borrow_name='"+prof_name+"' and book_name='"+book_name+"'");    
                    JOptionPane.showMessageDialog(null,"تم أسترجاع الكتاب");
                    
                }else{
                        JOptionPane.showMessageDialog(null,"لقد تم أسترجاع هذا الكتاب مسبقا");
                }


            }else{
               JOptionPane.showMessageDialog(null,"لم يتم أستقراض هذا الكتاب مسبقا"); 
            }
//        
        }else{
               JOptionPane.showMessageDialog(null,"لا يجب ترك احد الحقول فارغا"); 
        }       
        
       
     
}

}
    

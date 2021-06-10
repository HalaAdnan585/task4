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
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
class borrow {
HBox hbox3 = new HBox(50);
VBox vBox10 = new VBox(10);
TextField txt_student_name = new TextField();
TextField txt_field_prof = new TextField();
Text t13 = new Text("Student Name");
private ComboBox <String> book_list = new ComboBox<>();
VBox vBox13 = new VBox(10);
HBox hbox4 = new HBox(50);
VBox vBox11 = new VBox(10);
Text t14 = new Text("Professor Name");
HBox hbox2 = new HBox(50);
VBox vBox14 = new VBox(10);
HBox hbox1 = new HBox(50);
VBox vBox8 = new VBox(10);
VBox vBox15 = new VBox(10);
 Button button24 = new Button("Student");
 Button button25 = new Button("Professor");
 Button button26 = new Button("BORROW");
 Button button27 = new Button("BORROW");
 PreparedStatement preparedStatement;
 Connection con=null;
 ResultSet rset=null;
 PreparedStatement pd=null;

  private Statement stmt;
  private TextField studentNum = new TextField();
  private Button delet = new Button("DELET");
  private Label lblStatus = new Label();
  private Label lblStatus2 = new Label();
  String data[] = new String[100];
  
    String queryString = "";
    
   // private ComboBox <String> borrow = new ComboBox<>();
    
   
    /**
     * @param args the command line arguments
     */private void BStudent(){
         
      hbox3.setAlignment(Pos.CENTER);
      hbox3.setStyle("-fx-size: 10");
      hbox3.getChildren().addAll(t13,txt_student_name, book_list,button26);
      vBox10.setStyle("-fx-border-color: black");
      vBox10.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      vBox10.getChildren().addAll(hbox3);
      vBox13.getChildren().addAll(hbox4); 
      vBox13.getChildren().clear(); 
      
        
    
       
         
}
     
      private void borrow_student() throws SQLException {
        
        String student_name= txt_student_name.getText();
        String book_name = book_list.getValue();
        
        ResultSet rset = stmt.executeQuery("SELECT * FROM borrow where borrow_name='"+student_name+"' and book_name='"+book_name+"'");
        
        if(student_name!="" && book_name!="borrow Books"){
         
            if(rset.next() == false){

                ResultSet rset2 = stmt.executeQuery("SELECT count(*) as all2 FROM `borrow` where borrow_name='"+student_name+"' and flag='1'");

                if(rset2.next()){
                    if(Integer.parseInt(rset2.getString("all2")) < 2 ){

                        stmt.executeUpdate("UPDATE book SET flag = 1 WHERE title='"+book_name+"'"); 
                        stmt.executeUpdate("INSERT INTO borrow (borrow_name,borrow_type,book_name,flag) VALUES('"+student_name +"','student','"+ book_name +"','1')");    
                        JOptionPane.showMessageDialog(null,"تم أستقراض الكتاب");
                    }else{
                        JOptionPane.showMessageDialog(null,"لا يمكن أستقراض اكثر من 2 كتب");
                    }
                }


            }else{
               JOptionPane.showMessageDialog(null,"لقد تم أستقراض هذا الكتاب مسبقا"); 
            }
//        
        }else{
               JOptionPane.showMessageDialog(null,"لا يجب ترك احد الحقول فارغا"); 
        }
//      
    }
 
     private void initializeDB() {
        
     
     String user="root";
     String password="123456789";
     String conn="jdbc:mysql://localhost:3306/library?verifyServerCertificate=false&useSSL=true";
    
       try {
             con=DriverManager.getConnection(conn,user,password);
           stmt= con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
private void BProfessor()throws SQLException{
    
    
    
      hbox4.getChildren().addAll(t14,txt_field_prof, book_list,button27);
      hbox4.setAlignment(Pos.CENTER);
      hbox4.setStyle("-fx-size: 10");
      vBox11.getChildren().addAll(hbox4);
      vBox11.setStyle("-fx-border-color: black");
      vBox11.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      vBox14.getChildren().addAll(hbox2); 
      vBox14.getChildren().clear(); 
      vBox13.getChildren().addAll(vBox10); 
}
    
    
   private void borrow_prof()throws SQLException{
    
    String Prof_name= txt_field_prof.getText();
    String book_name = book_list.getValue();
     
    // ResultSet rset1 = stmt.executeQuery("SELECT * FROM professors where name='"+Prof_name+"' ");
     ResultSet rset = stmt.executeQuery("SELECT * FROM borrow where borrow_name='"+Prof_name+"' and book_name='"+book_name+"'");
     
//     if(rset1.next()== false){
//                JOptionPane.showMessageDialog(null,"هذا المستخدم غير موجود");  
//             }
     
     if(Prof_name!="" && book_name!="borrow Books"){
         
            if(rset.next() == false){

                ResultSet rset2 = stmt.executeQuery("SELECT count(*) as all2 FROM `borrow` where borrow_name='"+Prof_name+"' and flag='1'");
//  
             
                if(rset2.next()){
                    if(Integer.parseInt(rset2.getString("all2")) < 5 ){

                        stmt.executeUpdate("UPDATE book SET flag = 1 WHERE title='"+book_name+"'"); 
                        stmt.executeUpdate("INSERT INTO borrow (borrow_name,borrow_type,book_name,flag) VALUES('"+Prof_name +"','Professor','"+ book_name +"','1')");    
                        JOptionPane.showMessageDialog(null,"تم أستقراض الكتاب");
                    }else{
                        JOptionPane.showMessageDialog(null,"لا يمكن أستقراض اكثر من 2 كتب");
                    }
                }


            }else{
               JOptionPane.showMessageDialog(null,"لقد تم أستقراض هذا الكتاب مسبقا"); 
            }
//    
            
        }else{
               JOptionPane.showMessageDialog(null,"لا يجب ترك احد الحقول فارغا"); 
        }
     
     
     
        
    }
    
    

    
    public void start(Stage primaryStage) throws Exception {
        initializeDB();
         hbox1.getChildren().addAll(button24,button25);
         hbox1.setAlignment(Pos.CENTER);
         
         vBox8.getChildren().addAll(hbox1);
         vBox15.getChildren().addAll(vBox10,vBox11);
         vBox8.setStyle("-fx-border-color: black;"
                 + "-fx-background-color: green");
         vBox8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
         
         BorderPane pane = new BorderPane();
         pane.setTop(vBox8); 
         pane.setCenter(vBox15);
        // pane.setCenter(vBox11);
        
        book_list.setValue("borrow Books");
         String sql="select * from book where flag = 0  ";
         ResultSet rset5 = stmt.executeQuery(sql);
         while(rset5.next()){
         String title = rset5.getString("title");
         String books = title ;
         book_list.getItems().addAll(books);
         } 
        
        //button24.setOnAction(e -> get_book());
        button24.setOnAction(e -> BStudent());

        button25.setOnAction(e -> {
            try {
                BProfessor();
            } catch (SQLException ex) {
                Logger.getLogger(borrow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         button26.setOnAction(e -> {
           try {
               borrow_student();
           } catch (SQLException ex) {
               Logger.getLogger(borrow.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
         
         button27.setOnAction(e -> {
           try {
                borrow_prof();
           } catch (SQLException ex) {
               Logger.getLogger(borrow.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
        
          
     Stage stage = new Stage(); // Create a new stage
    stage.setTitle("Second Stage"); // Set the stage title
    // Set a scene with a button in the stage
    stage.setScene(new Scene(pane, 700, 200));        
    stage.show(); // Display the stage
    }
    
}

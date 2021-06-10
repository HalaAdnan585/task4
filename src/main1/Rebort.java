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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author HP
 */
class Rebort {
        
    
    
    private Statement stmt;
    private Label lblStatus = new Label();
    private Label lblStatus1 = new Label();
    private Label lblStatus2 = new Label();
    private Label lblStatus3 = new Label();
    private Label lblStatus4 = new Label();
    
    private Label result = new Label();
    
    private Button Avilabel_book= new Button("Avilabel book");
     private Button Borrowed_book = new Button("Borrowed books");
     private Button Existing_users = new Button("Existing users");
     private Button bookBorred_byUser = new Button("book Borred by User ");
     private Button Deleted_book = new Button("Deleted book");
     
     private Button show= new Button("show");
     
      HBox hbox8 = new HBox(50);
      HBox hbox6 = new HBox(50);
      HBox hbox5 = new HBox(50);
      HBox hbox3 = new HBox(50);
      HBox hbox4 = new HBox(50);
      VBox vBox10 = new VBox(10);
      HBox hbox1 = new HBox(50);
      
      //لعرض نتائج كل مثد
      VBox hBox_avilabel_book = new VBox(10);
      
      VBox hbox_borrow_book = new VBox(10);
      VBox hbox_existing_user = new VBox(10);
      VBox hbox_book_borroBY_user = new VBox(10);
      VBox hbox_deleted_book = new VBox(10);
      //HBox hbox14 = new HBox(50);
      
      VBox hBox2 = new VBox(10);
      VBox vBox21 = new VBox(10);
     // VBox vBox15 = new VBox(10);
      VBox vBox16 = new VBox(10);
      VBox vBox13 = new VBox(10);
      
      HBox avilabel_user = new HBox(50);
      HBox hBox_home = new HBox(100);
      TextField Text_Field_existingUSER = new TextField();

      Text t13 = new Text("user Name");
      TextField txt14 = new TextField();
      Text t15 = new Text("user Name");
      
      String result_Query="";
      
      
        //    
        VBox vBox8 = new VBox(10);
        VBox vBox11 = new VBox(10);
        VBox vBox15 = new VBox(10);
         Button button24 = new Button("Student");
         Button button25 = new Button("Professor");

         BorderPane pane = new BorderPane();
 
 
      Button ptn_student = new Button("Student");
      Button ptn_prof = new Button("Professor");
      VBox vBox1 = new VBox(15);

     
public void start(Stage primaryStage) {
    
    initializeDB();
    
        hbox1.getChildren().addAll(button24,button25);
         hbox1.setAlignment(Pos.CENTER);
         
         vBox8.getChildren().addAll(hbox1);
         vBox15.getChildren().addAll(vBox10,vBox11);
         vBox8.setStyle("-fx-border-color: black;"
                 + "-fx-background-color: blue");
         vBox8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
         
         //BorderPane pane = new BorderPane();
         pane.setTop(vBox8); 
         pane.setCenter(vBox15);
         
    
         hbox8.getChildren().addAll(Avilabel_book,Borrowed_book, Existing_users,bookBorred_byUser,Deleted_book);
         hbox8.setAlignment(Pos.CENTER);

         vBox21.getChildren().addAll(hbox8);
         vBox21.setStyle("-fx-border-color: black;"
                     + "-fx-background-color: green");
         vBox21.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
         // vBox22.getChildren().addAll(vBox16,vBox17);

         vBox1.getChildren().addAll(avilabel_user);
         pane.setCenter(vBox1);

         Avilabel_book.setOnAction(e -> avilabelB());
         Borrowed_book.setOnAction(e -> boroB());
         Existing_users.setOnAction(e -> avilabel_user());
         bookBorred_byUser.setOnAction(e -> bookBorowBy_user());
         show.setOnAction(e -> {
        try {
            show_book();
        } catch (SQLException ex) {
            Logger.getLogger(Rebort.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
     
      Existing_users.setOnAction(e -> avilabel_user());
      ptn_student.setOnAction(e -> avilabel_student());
      ptn_prof.setOnAction(e -> avilabel_prof());
     
      Deleted_book.setOnAction(e -> deleted_book());
     
//    BorderPane pane = new BorderPane();
      pane.setTop(vBox21); 
      //   pane.setCenter(hBox1);
        // pane.setCenter(vBox11);
       
        //عرض محتويات اللابل لكل مثد
         hBox_avilabel_book.getChildren().addAll(lblStatus);
         hbox_borrow_book.getChildren().addAll(lblStatus1);
         hbox_deleted_book.getChildren().addAll(lblStatus4);
      
     Stage stage = new Stage(); // Create a new stage
    stage.setTitle("Second Stage"); // Set the stage title
    // Set a scene with a button in the stage
    stage.setScene(new Scene(pane, 750, 400));        
    stage.show();
    
}

 private void avilabelB() {
     
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
     TableView tableview = new TableView();
     
          try{
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM book WHERE flag=0");

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableview.getColumns().addAll(col); 
                //System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
               // System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
  
        hBox_avilabel_book.setStyle("-fx-border-color: black;");
       hBox_avilabel_book.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
       
         pane.setCenter(tableview);
    
 }
 
       private void boroB() {

        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        TableView tableview = new TableView();

          try{
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM book WHERE flag=1");

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableview.getColumns().addAll(col); 
                //System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
               // System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
  
        hBox_avilabel_book.setStyle("-fx-border-color: black;");
       hBox_avilabel_book.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
       
         pane.setCenter(tableview);
  }
  
  private void avilabel_user() {
     
     avilabel_user.getChildren().clear();
     avilabel_user.getChildren().addAll(ptn_student,ptn_prof);
     avilabel_user.setAlignment(Pos.CENTER);
     avilabel_user.setPadding(new Insets(20.5, 20.5, 20.5, 20.5));
     pane.setCenter(avilabel_user);
     ptn_student.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
     ptn_prof.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
        
  }
  
  private void avilabel_student() {
      
      
      
      
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
     TableView tableview = new TableView();
     
          try{
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM `students`");

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableview.getColumns().addAll(col); 
                //System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
               // System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
            
            
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
  
        hBox_avilabel_book.setStyle("-fx-border-color: black;");
       hBox_avilabel_book.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
       
      
      avilabel_user.getChildren().clear();
     
     pane.setCenter(tableview); 
      
    
  }
  
  private void avilabel_prof() {
      
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
     TableView tableview = new TableView();
     
          try{
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM `professors`");

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableview.getColumns().addAll(col); 
                //System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
               // System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
            
            
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }

         hBox_avilabel_book.setStyle("-fx-border-color: black;");
         hBox_avilabel_book.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
         avilabel_user.getChildren().clear();
         pane.setCenter(tableview); 

  }
  
  private void bookBorowBy_user() {
     
      hbox3.setAlignment(Pos.CENTER);
      hbox3.setStyle("-fx-size: 10");
      hbox3.getChildren().clear();
      hbox3.getChildren().addAll(t13,Text_Field_existingUSER, show);
      pane.setCenter(hbox3); 
  }
  private void show_book() throws SQLException {
      
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
     TableView tableview = new TableView();
     String user_name= Text_Field_existingUSER.getText();
     
          try{
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM borrow where borrow_name='"+user_name+"' and flag=1");

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableview.getColumns().addAll(col); 
                //System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
               // System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
            
            
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
  
        hBox_avilabel_book.setStyle("-fx-border-color: black;");
       hBox_avilabel_book.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
       hbox3.getChildren().clear();
         pane.setCenter(tableview);
     
   
  }
  
   private void deleted_book() {
     hbox_deleted_book.getChildren().clear();
     hbox_deleted_book.getChildren().addAll(t13,Text_Field_existingUSER, show);   
     hbox_deleted_book.getChildren().clear();
     
     
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
     TableView tableview = new TableView();
     String user_name= Text_Field_existingUSER.getText();
     
          try{
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM book where flag=2");
            //ResultSet rs = stmt.executeQuery("SELECT * FROM borrow where flag=0");

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableview.getColumns().addAll(col); 
                //System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
               // System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
            
            
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
  
        hBox_avilabel_book.setStyle("-fx-border-color: black;");
       hBox_avilabel_book.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
       
         pane.setCenter(tableview);
      
     
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          launch(args);
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
       
    }
    
}

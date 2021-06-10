/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main1;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class main1 extends Application{
    
    private Button add = new Button("ADD");
    private Button delet = new Button("Delet");
    private Button bor = new Button("BOR/RET");
    private Button report = new Button("REPORTS");
    private Button exit = new Button("EXIT");
    Label label=new Label("AN-Najah National University Library");
  //  label.setStyle("-fx-border-color:black");
    
     private final Button add_book = new Button("Book");
     private Button add_prof = new Button("Professor");
     private Button add_student = new Button("Student");
     
//     add_book.setMaxSize(100, 200);
     //add_book.setMaxWidth(100);
     //add_book.setMaxHeight(200);
     
     private Button delet_book = new Button("Book");
     private Button delet_prof = new Button("Professor");
     private Button delet_student = new Button("Student");
     
     private Button Borrow = new Button("Borrow");
     private Button Return = new Button("reurn");
     
     private Button Avilabel_users = new Button("Avilabel users");
     private Button Borrowed_book = new Button("Borrowed books");
     private Button Existing_users = new Button("Existing users");
     private Button bookBorred_byUser = new Button("book Borred by User ");
     private Button Deleted_book = new Button("Deleted book");
     
     GridPane gridPane = new GridPane();
      BorderPane pane = new BorderPane();
         Stage stage = new Stage();
      
       VBox vBox = new VBox(15);
       VBox vBox1 = new VBox(15);
       VBox vBox2 = new VBox(15);
       VBox vBox21 = new VBox(10);
       
       HBox h1 = new HBox(10); 
       HBox hbox8 = new HBox(50);
       
       HBox hbox_add = new HBox(50);
       HBox hbox_delet = new HBox(50);
       HBox hbox_BOROW_return = new HBox(50);
     //  add_book.setPrefColumnCount(30);

     public void start(Stage primaryStage) {
  /*       
    // Create a border pane 
    h1.getChildren().addAll(add,delet,bor,report,exit);
    vBox1.getChildren().addAll(h1,vBox);
     
     
   // gridPane.setAlignment(Pos.CENTER);
    // Scene scene = new Scene(gridPane, 400, 250);
    
   
    pane.setCenter(vBox1);
    BorderPane.setAlignment(pane, Pos.CENTER);
    pane.setTop(label);
    label.setStyle("-fx-size:40");
     pane.setTop(new CustomPane("AN-Najah National University Library")); 
    BorderPane.setAlignment(label, Pos.CENTER);
    pane.setStyle("-fx-border-color:black");
    
       // vBox.setPadding(new Insets(15, 5, 5, 5));

*/
  
    hbox8.getChildren().addAll(add,delet, bor,report,exit);
      hbox8.setAlignment(Pos.CENTER);
      
      vBox21.getChildren().addAll(hbox8);
      vBox21.setStyle("-fx-border-color: black;"
                 + "-fx-background-color: green");
      vBox21.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      pane.setCenter(vBox1);
     // vBox22.getChildren().addAll(vBox16,vBox17);
   
   
     
//      BorderPane pane = new BorderPane();
         pane.setTop(vBox21); 
         
         vBox1.getChildren().addAll(h1,hbox_add,hbox_delet,hbox_BOROW_return);
          pane.setCenter(vBox1);
         
         //hbox_add.getChildren().addAll(add_book,add_prof,add_student);
          
          
         // hbox_add.getChildren().addAll(add_book,add_prof,add_student);
         //hbox_delet.getChildren().addAll(delet_book,delet_prof,delet_student);
  
    add.setOnAction(e -> addlist());
    delet.setOnAction(e -> delet());
    exit.setOnAction(e -> close());
    bor.setOnAction(e -> por_ret());
//    report.setOnAction(e -> report());
    
    add_book.setOnAction(e -> addBook());
    add_prof.setOnAction(e -> addProf());
    add_student.setOnAction(e -> addStudent());
    
    delet_book.setOnAction(e ->  deletBook());
    delet_student.setOnAction(e -> deletStudent());
    delet_prof.setOnAction(e -> deletPROF());
    report.setOnAction(e -> reports());
    
    
   // Return.setOnAction(e -> returnBOOK());
     
   Borrow.setOnAction(e -> boroBOOK());
   Return.setOnAction(e -> retrive());
   
//   add.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
    
     Scene scene = new Scene(pane, 550, 300);
     stage.setResizable(false);
    stage.setTitle("main"); // Set title
    stage.setScene(scene); // Place the scene in the stage
    stage.show();
  }
     
      private void addlist() {
   /*  GridPane gridPane2 = new GridPane();
    
     gridPane2.setHgap(5);
     gridPane2.setVgap(5);
     gridPane2.add(add_book , 20, 17);
     gridPane2.add(add_prof, 20, 19);
     gridPane2.add(add_student, 20 , 21);
     
     pane.getChildren().addAll(gridPane2);
  // pane.getChildren().clear(); */ 
      
   
 //  pane.getChildren().addAll(hbox_add);
    //   hbox_add.getChildren().clear();

   
    hbox_delet.getChildren().clear();
    hbox_BOROW_return.getChildren().clear();
    hbox_add.getChildren().clear();
    hbox_add.getChildren().addAll(add_book,add_prof,add_student);
    hbox_add.setAlignment(Pos.CENTER);
    
    
    
    
    
    
    //hbox_add.setAlignment(Pos.BASELINE_LEFT);
    
    // vBox.setStyle(STYLESHEET_MODENA);
   // vBox.setPadding(new Insets(11.5 , 12.5 ,13.5,14.5));
   
      add_book.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
      add_prof.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
      add_student.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
      }
      
        private void delet() {
    //hbox_add.removeAll();
    
//    hbox_delet.getChildren().removeAll(delet_book,delet_prof,delet_student);
    
    hbox_add.getChildren().clear();
    hbox_BOROW_return.getChildren().clear();
    hbox_delet.getChildren().clear();
    hbox_delet.getChildren().addAll(delet_book,delet_prof,delet_student);
    hbox_delet.setAlignment(Pos.CENTER);
     
      delet_book.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
      delet_prof.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
      delet_student.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
     
     
  // pane.getChildren().clear();
      
      }
        
      private void close() {
//primaryStage.setOnCloseRequest( event -> {System.out.println("Closing Stage");} );
stage.close();
      } 
                  
     private void por_ret() {
     
       
    
     hbox_add.getChildren().clear();
     hbox_delet.getChildren().clear();
     hbox_BOROW_return.getChildren().clear();
     hbox_BOROW_return.getChildren().addAll(Borrow,Return);
     hbox_BOROW_return.setAlignment(Pos.CENTER);
   
     
     Borrow.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
      Return.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
      } 
     
        private void report() {
      
     vBox.getChildren().addAll(Avilabel_users,Borrowed_book,Existing_users,bookBorred_byUser,Deleted_book);
     vBox2.getChildren().addAll(Borrow,Return,add_book,add_prof,add_student,delet_book,delet_prof,delet_student);
     vBox2.getChildren().clear();
      } 
        
             private void addBook() {
                 try {
     add_book C1 = new add_book();
     C1.start(stage);
                 }catch (Exception ex) {
            ex.printStackTrace();
        }
    //C1.start(new addBstage());
    
      }
             
    private void addProf() {
        try {
     add_prof C2 = new add_prof();
    // C1.start(stage);
     C2.start(stage);
                 }catch (Exception ex) {
            ex.printStackTrace();
        }
    //C1.start(new addBstage());
    
      }
    
    private void addStudent() {
        try {
     add_student C3 = new add_student();
     C3.start(stage);
                 }catch (Exception ex) {
            ex.printStackTrace();
        }
    //C1.start(new addBstage());
    
      }
    private void deletBook() {
        try {
     delet_book C3 = new delet_book();
     C3.start(stage);
                 }catch (Exception ex) {
            ex.printStackTrace();
        }
    //C1.start(new addBstage());
    
      }
        private void deletStudent() {
        try {
     delet_student C3 = new delet_student();
     C3.start(stage);
                 }catch (Exception ex) {
            ex.printStackTrace();
        }
      }     
     
            private void deletPROF() {
        try {
     delet_prof C3 = new delet_prof();
     C3.start(stage);
                 }catch (Exception ex) {
            ex.printStackTrace();
        }
            }
            
          private void reports() {
        try {
     Rebort C3 = new Rebort();
     C3.start(stage);
    }catch (Exception ex) {
     ex.printStackTrace();
        }
            }     
          
      private void boroBOOK() {
        try {
     borrow C3 = new borrow();
     C3.start(stage);
     }catch (Exception ex) {
       ex.printStackTrace();
        }
            } 
      
       private void retrive() {
        try {
     Return C3 = new Return();
     C3.start(stage);
      }catch (Exception ex) {
      ex.printStackTrace();
        }
            } 
      
    public static void main(String[] args) {
        // TODO code application logic here
         launch(args);
     }
}
class CustomPane extends StackPane {
  public CustomPane(String title) {
    getChildren().add(new Label(title));
    setStyle("-fx-border-color: green");
    setStyle("-fx-background-color: green");
    setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
  }
}


 //button.setTranslateX(135);
   //     button.setTranslateY(100);
 
        // button هنا قمنا بتغيير نوع و حجم خط الكائن
     //   button.setFont(new Font("Arial", 20));
 
        // button هنا قمنا بتغيير لون خط الكائن
       // button.setTextFill(Color.RED);
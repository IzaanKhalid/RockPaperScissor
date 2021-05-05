
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

public class RockPaperScissor extends Application
{
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage) throws FileNotFoundException
   {
      // Creating variables for user input and computer output
      int computer, user;
      
      // Scene title
      primaryStage.setTitle("Rock Paper Scissor");
      
      // Scene dimensions
      double width = 600.0, height = 200.0;
      
      // Random whole number from 0-2
      int min = 0, max = 2;
      computer = (int)Math.floor(Math.random()* (max-min+1)+min);
      System.out.println(computer);
      
      // Creating Image for rock(image), paper(image1) and scissor(image2)
      Image image = new Image(new FileInputStream("./Rock.png"));
      Image image1 = new Image(new FileInputStream("./Paper.png"));
      Image image2 = new Image(new FileInputStream("./Scissor.png"));
      
      // Setting the ImageView for rock, paper and scissor Image
      ImageView Rock = new ImageView(image);
      ImageView Paper = new ImageView(image1);
      ImageView Scissor = new ImageView(image2);
      
      // Setting the fit height and width of rock paper and scissor ImageView
      Rock.setFitHeight(150);
      Rock.setFitWidth(250);
      Paper.setFitHeight(150);
      Paper.setFitWidth(250);
      Scissor.setFitHeight(150);
      Scissor.setFitWidth(250);
      
      // Setting the preservation ratio of rock paper and scissor ImageView
      Rock.setPreserveRatio(true);
      Paper.setPreserveRatio(true);
      Scissor.setPreserveRatio(true);
      
      // Creating the buttons for Rock(button), Paper(button1), 
      //    scissor(button2) and a restart button
      Button button = new Button();
      Button button1 = new Button();
      Button button2 = new Button();
      Button restart = new Button("Restart");
      
      // Setting the graphic to the buttons
      button.setGraphic(Rock);
      button1.setGraphic(Paper);
      button2.setGraphic(Scissor);
      
      // Create a label for the output
      Label text = new Label("");;
      
      // Create a second scene to show who won
      HBox hbox2 = new HBox(10, text, restart);
      Scene scene2 = new Scene(hbox2, width, height);
      
      // Getting user input
      button.setOnAction(value -> {
         text.setText(Rock(computer));
         primaryStage.setScene(scene2);
      });
      
      button1.setOnAction(value -> {
         text.setText(Paper(computer));
         primaryStage.setScene(scene2);
      });
      
      button2.setOnAction(value -> {
         text.setText(Scissor(computer));
         primaryStage.setScene(scene2);
      });

 
      // Creating an HBox to show all the buttons  
      HBox hbox = new HBox(10, button, button1, button2);
      
      // Create a BorderPane with the sample text in the center.
      BorderPane borderPane = new BorderPane(hbox);

      // Create a Scene and display it.
      Scene scene = new Scene(borderPane, width, height);
      primaryStage.setScene(scene);
      primaryStage.show();
      
      // Making restart button work
      restart.setOnAction(value -> {
         primaryStage.setScene(scene);
      });
      
   }
   public String Rock(int comp){
      String output = "";
      if(comp == 0)
         output = "Computer chose Rock: Draw!";
      else if(comp == 1)
         output = "Computer chose Paper: You lose! :(";
      else if(comp == 2)
         output = "Computer chose Scissor: You win ! :)";
      return output;
   }
   
   public String Paper(int comp){
      String output = "";
      if(comp == 0)
         output = "Computer chose Rock: You win! :)";
      else if(comp == 1)
         output = "Computer chose Paper: Draw!";
      else if(comp == 2)
         output = "Computer chose Scissor: You lose! :(";
      return output;
   }
   public String Scissor(int comp){
      String output = "";
      if(comp == 0)
         output = "Computer chose Rock: You lose! :(";
      else if(comp == 1)
         output = "Computer chose Paper: You win! :)";
      else if(comp == 2)
         output = "Computer chose Scissor: Draw!";
      return output;
   }
   
}
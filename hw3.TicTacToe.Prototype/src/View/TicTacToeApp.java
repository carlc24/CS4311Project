/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Control.AIMove;
import Control.AttributeIterator;
import Control.GameAttribute;
import Model.InGameButton;
import Model.UniqueChecker;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author verastu
 */
public class TicTacToeApp extends Application {
    
    private AttributeIterator attIt;
    private GameAttribute gameAtt;
    private InGameButton btninfo;
    private List<List<Button>> btnlist;
    
    @Override
    public void start(Stage primaryStage) {
        gameAtt = new GameAttribute();
        
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 400, 500);
        
        gameAtt.setCurrPlayer(-1);
        Button gamebtn = new Button();
        gamebtn.setText("Player vs Player");
        gamebtn.setPrefSize(200,50);
        gamebtn.relocate(100, 300);
        gamebtn.setOnAction((ActionEvent event) -> {
            setTicTacToe(root,100,100,300,300,3);		// sets up the game on the press of button
            gameAtt.setCurrPlayer(0);
   
        });
        root.getChildren().add(gamebtn);
        
        gameAtt.setCurrPlayer(-1);
        Button aibtn = new Button();
        aibtn.setText("Play vs AI");
        aibtn.setPrefSize(200,50);
        aibtn.relocate(100, 350);
        aibtn.setOnAction((ActionEvent event) -> {
            setAITicTacToe(root,100,100,300,300,3);		// sets up the game on the press of button 
            gameAtt.setCurrPlayer(0);
            //userControl = 0;
        });
        root.getChildren().add(aibtn);
        
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // This sets the button for the Player vs Player option of the game
    public void setTicTacToe(AnchorPane root, int start_x, int start_y, int end_x, int end_y, int size){
        gameAtt.initAttInfo("X", "O", "-", 3);		// setting the size of board and the symbols that will be used in game.	
        int tempX = (end_x - start_x) / (size);
        int tempY = (end_y - start_y) / (size);
        btnlist = new ArrayList<>();
        btninfo = new InGameButton(btnlist,gameAtt);
        
        for(int _row = 0; _row<size ; _row++){
            btnlist.add(new ArrayList<>());
            for(int _col = 0; _col<size; _col++){
                Button newbtn = new Button();
                newbtn.setPrefSize(tempX, tempY);
                btninfo.setPvPButton(newbtn, tempX, tempY, start_x+tempX*_row, start_y+tempY*_col); // most of the logic that goes into the game called from here
                btnlist.get(_row).add(newbtn);
                root.getChildren().add(newbtn);
            }    
        }
    }
    
 // This sets the button for the Player vs AI option of the game
    public void setAITicTacToe(AnchorPane root, int start_x, int start_y, int end_x, int end_y, int size){
        gameAtt.initAttInfo("X", "O", "-", 3);				// setting the size of board and the symbols that will be used in game.
        int tempX = (end_x - start_x) / (size);
        int tempY = (end_y - start_y) / (size);
        btnlist = new ArrayList<>();
        btninfo = new InGameButton(btnlist,gameAtt);
        
        for(int _row = 0; _row<size ; _row++){
            btnlist.add(new ArrayList<>());
            for(int _col = 0; _col<size; _col++){
                Button newbtn = new Button();
                newbtn.setPrefSize(tempX, tempY);
                btninfo.setAIButton(newbtn, tempX, tempY, start_x+tempX*_row, start_y+tempY*_col); // most of the logic that goes into the game called from here
                btnlist.get(_row).add(newbtn);
                root.getChildren().add(newbtn);
            }    
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
      
    }
    
}

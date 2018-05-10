/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Control.AttributeIterator;
import Control.GameAttribute;
import Model.InGameButton;
import Model.UniqueChecker;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 *
 * @author verastu
 */
public class TicTacToeApp extends Application {
    
    private AttributeIterator attIt;
    private GameAttribute gameAtt;
    private InGameButton btninfo;
    private UniqueChecker cker;
    private List<List<Button>> btnlist;
    
    int userControl;
    
    @Override
    public void start(Stage primaryStage) {
        gameAtt = new GameAttribute();
        gameAtt.initAttInfo("X", "O", "-", 3);
        
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 400, 500);
        
        userControl = 0;
        Button gamebtn = new Button();
        gamebtn.setText("Player vs Player");
        gamebtn.setPrefSize(200,50);
        gamebtn.relocate(100, 300);
        gamebtn.setOnAction((ActionEvent event) -> {
            //setTicTacToe(root,100,100,300,300,3);
            userControl = 1;
            //System.out.println("Hello World!");
        });
        //root.getChildren().add(gamebtn);
        
        Button aibtn = new Button();
        aibtn.setText("Play vs AI");
        aibtn.setPrefSize(200,50);
        aibtn.relocate(100, 350);
        aibtn.setOnAction((ActionEvent event) -> {
            //setAITicTacToe(root,100,100,300,300,3);
            userControl = 1;
        });
        root.getChildren().add(aibtn);
        
        primaryStage.setTitle("TicTacToe");
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

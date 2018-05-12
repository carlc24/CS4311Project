/**
 * This is the test driver class for TicTacToe that uses JavaFX GUI interface
 * @author It is created and modifed by Jia Shin Tseng & Carl Chung
 * Last modified in May 11, 2018
 */

package View;
import Control.GameAttribute;
import Model.InGameButton;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class TicTacToeApp extends Application {
    //API objects
    private GameAttribute gameAtt;
    //GUI objects
    private InGameButton btninfo;
    //class objects
    private List<List<Button>> btnlist;
    
    /** Function: start
     * @Comment: Predefined JavaFX class that is used to start up the GUI interface.
     * @Pre: n/a
     * @Post: n/a
     */
    @Override
    public void start(Stage primaryStage) {
        // attribute objects
        gameAtt = new GameAttribute();
        
        // screen objects
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 400, 500);
        
        // allows no players to play the game
        gameAtt.setCurrPlayer(-1);
        
        // initilized the "Player vs Player" button
        Button gamebtn = new Button();
        gamebtn.setText("Player vs Player");
        gamebtn.setPrefSize(200,50);
        gamebtn.relocate(100, 300);
        gamebtn.setOnAction((ActionEvent event) -> {
            // initilized the "Player vs Player" information"
            setTicTacToe(root,100,100,300,300,3);
            // set Current player to player1
            gameAtt.setCurrPlayer(0);
        });
        // add to the screen
        root.getChildren().add(gamebtn);
        
        // initilized the "Player vs AI" button
        Button aibtn = new Button();
        aibtn.setText("Play vs AI");
        aibtn.setPrefSize(200,50);
        aibtn.relocate(100, 350);
        aibtn.setOnAction((ActionEvent event) -> {
            // initilized the "Player vs AI" information"
            setAITicTacToe(root,100,100,300,300,3);
            // set Current player to player1
            gameAtt.setCurrPlayer(0);
        });
        // add to the screen
        root.getChildren().add(aibtn);
        
        // set screen inforamtion
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        // display the new frame
        primaryStage.show();
    }
    /** Function: setTicTacToe
     * @Comment: This sets the button for the Player vs Player option of the game
     * @Pre: root and global object gameAtt must be initialized 
     * @Post: n/a
     */
    public void setTicTacToe(AnchorPane root, int start_x, int start_y, int end_x, int end_y, int size){
        // initialize the game information;
        gameAtt.initAttInfo("X", "O", "-", size);
        
        // position parameters
        int tempX = (end_x - start_x) / (size);
        int tempY = (end_y - start_y) / (size);
        
        // the list of buttons and their information
        btnlist = new ArrayList<>();
        btninfo = new InGameButton(btnlist,gameAtt);
        
        // initialize the buttons and add to the screen
        for(int _row = 0; _row<size ; _row++){
            btnlist.add(new ArrayList<>());
            for(int _col = 0; _col<size; _col++){
                Button newbtn = new Button();
                newbtn.setPrefSize(tempX, tempY);
                btninfo.setPvPButton(newbtn, tempX, tempY, start_x+tempX*_row, start_y+tempY*_col);
                btnlist.get(_row).add(newbtn);
                root.getChildren().add(newbtn);
            }    
        }
    }
    /** Function: setAITicTacToe
     * @Comment: This sets the button for the Player vs AI option of the game
     * @Pre: root and global object gameAtt must be initialized 
     * @Post: n/a
     */
    public void setAITicTacToe(AnchorPane root, int start_x, int start_y, int end_x, int end_y, int size){
        // initialize the game information;
        gameAtt.initAttInfo("X", "O", "-", size);
        
        // position parameters
        int tempX = (end_x - start_x) / (size);
        int tempY = (end_y - start_y) / (size);
        
        // the list of buttons and their information
        btnlist = new ArrayList<>();
        btninfo = new InGameButton(btnlist,gameAtt);
        
        // initialize the buttons and add to the screen
        for(int _row = 0; _row<size ; _row++){
            btnlist.add(new ArrayList<>());
            for(int _col = 0; _col<size; _col++){
                Button newbtn = new Button();
                newbtn.setPrefSize(tempX, tempY);
                btninfo.setPvAIButton(newbtn, tempX, tempY, start_x+tempX*_row, start_y+tempY*_col);
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

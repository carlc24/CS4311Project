/**
 * InGameButton class allows the user to initialize the attributes of buttons
 * @author It is created and modifed by Jia Shin Tseng & Carl Chung
 * Last modified in May 11, 2018
 */

package Model;

import Control.AIMove;
import Control.UniqueChecker;
import Control.GameAttribute;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
public class InGameButton {
    //API objects
    GameAttribute gameAtt;
    UniqueChecker cker;
    AIMove aimove;
    //class objects
    List<List<Button>> btns;
    
    /** Function: Constructor
     * @Pre: btns and gameAtt must be initialized, and defined
     * @Post: n/a
     */
    public InGameButton(List<List<Button>> _btns, GameAttribute _gameAtt){
        btns = _btns;
        gameAtt = _gameAtt;
        cker = new UniqueChecker();
        aimove = new AIMove();
    }
    
    /** Function: updateButton
     * @Comment function that updates the button to show AI movement
     * @Pre: btns must be initialized, and defined
     * @Post: _row and _col must be in the range
     */
    void updateButton(int _row,int _col){
        btns.get(_row).get(_col).setText(gameAtt.getAttInfo(_row,_col));
    }
    
    /** Function: updateAllButoon
     * @Comment function that updates all buttons to show AI movement
     * @Pre: btns must be initialized, and defined
     * @Post: n/a
     */
    void updateAllButoon(){
        for(int _row = 0; _row < gameAtt.getSize(); _row++){
            for(int _col = 0; _col < gameAtt.getSize(); _col++){
                btns.get(_row).get(_col).setText(gameAtt.getAttInfo(_row,_col));
            }
        }
    }
    
    /** Function: setPvPButton
     * @Comment set the Buttons for Player Vs Player
     * @Pre: gameAtt must be initialized, and defined
     * @Post: screen position parameters must be in the range
     */
    public void setPvPButton(Button newbtn, int size_x, int size_y, int pos_x, int pos_y){
        // defined the general information
        newbtn.setPrefSize(size_x, size_y);
        newbtn.relocate(pos_x, pos_y);
        newbtn.setText(gameAtt.getDefualtDesc());
        
        // set OnClick event
        newbtn.setOnAction((ActionEvent event) -> {
            if(gameAtt.getCurrPlayer() >= 0){
                // code start here
                if(newbtn.getText().equals(gameAtt.getDefualtDesc())){
                    for(int _row = 0; _row<gameAtt.getSize();_row++){
                        for(int _col = 0; _col<gameAtt.getSize();_col++){
                            if(btns.get(_row).get(_col).equals(newbtn)){
                                gameAtt.setAttInfo(_row, _col, gameAtt.getCurrPlayer());
                                gameAtt.NextPlayer();
                                updateButton(_row,_col);
                            }
                        }
                    }
                }
                else{
                    return;
                }
            }
            else if (gameAtt.getCurrPlayer() == -1){
                return;
            }
            if(cker.Checkwinner(gameAtt, gameAtt.getPlayer(0))){
                new Alert(Alert.AlertType.INFORMATION, gameAtt.getPlayer(0) + " is winner").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
            else if(cker.Checkwinner(gameAtt, gameAtt.getPlayer(1))){
                new Alert(Alert.AlertType.INFORMATION, gameAtt.getPlayer(1) + " is winner").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
            else if(!gameAtt.HasNextMove()){
                new Alert(Alert.AlertType.INFORMATION, "Tie").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
        });
    }
    
    /** Function: setPvAIButton
     * @Comment set the Buttons for Player Vs AI
     * @Pre: gameAtt must be initialized, and defined
     * @Post: screen position parameters must be in the range
     */
    public void setPvAIButton(Button newbtn, int size_x, int size_y, int pos_x, int pos_y){
        // defined the general information
        newbtn.setPrefSize(size_x, size_y);
        newbtn.relocate(pos_x, pos_y);
        newbtn.setText(gameAtt.getDefualtDesc());
        
        // set OnClick event
        newbtn.setOnAction((ActionEvent event) -> {
            if(gameAtt.getCurrPlayer() == 0){
                // Checks to see if button is empty and moves with player if button is not empty
                if(newbtn.getText().equals(gameAtt.getDefualtDesc())){
                    for(int _row = 0; _row<gameAtt.getSize();_row++){
                        for(int _col = 0; _col<gameAtt.getSize();_col++){
                            if(btns.get(_row).get(_col).equals(newbtn)){
                                // setting the value of the player move
                                gameAtt.setAttInfo(_row, _col, gameAtt.getCurrPlayer());
                                // If no result, make AI move
                                if(gameAtt.HasNextMove() && !cker.Checkwinner(gameAtt, gameAtt.getPlayer(gameAtt.getCurrPlayer())))
                                    aimove.EasyMove(gameAtt);
                                // Update the text of buttons
                                updateAllButoon();
                            }
                        }
                    }
                }
                else{
                    return;
                }
            }
            else if (gameAtt.getCurrPlayer() == -1){
                return;
            }
            // Check whether it has a winner or die, and set the currentPlayer to 1 (Gameover)
            if(cker.Checkwinner(gameAtt, gameAtt.getPlayer(0))){
                new Alert(Alert.AlertType.INFORMATION, gameAtt.getPlayer(0) + " is winner").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
            else if(cker.Checkwinner(gameAtt, gameAtt.getPlayer(1))){
                new Alert(Alert.AlertType.INFORMATION, gameAtt.getPlayer(1) + " is winner").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
            else if(!gameAtt.HasNextMove()){
                new Alert(Alert.AlertType.INFORMATION, "Tie").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
        });
    }
}

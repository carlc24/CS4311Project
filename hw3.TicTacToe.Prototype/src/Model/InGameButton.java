/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Control.AIMove;
import Control.GameAttribute;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 *
 * @author verastu
 */
public class InGameButton {
    List<List<Button>> btns;
    GameAttribute gameAtt;
    UniqueChecker cker;
    List<List<String>> btnstrs;
    public InGameButton(List<List<Button>> _btns, GameAttribute _gameAtt){
        btns = _btns;
        gameAtt = _gameAtt;
        cker = new UniqueChecker();
    }
    void updateButton(int _row,int _col){
        btns.get(_row).get(_col).setText(gameAtt.getAttInfo(_row,_col));
    }
    // function that updates the buttons to show AI movement
    void updateAllButton(){
        for(int _row = 0; _row < gameAtt.getSize(); _row++){
            for(int _col = 0; _col < gameAtt.getSize(); _col++){
                btns.get(_row).get(_col).setText(gameAtt.getAttInfo(_row,_col));
            }
        }
    }
    
    // Button that is used for Player Vs Player
    public void setPvPButton(Button newbtn, int size_x, int size_y, int pos_x, int pos_y){
        newbtn.setPrefSize(size_x, size_y);
        newbtn.relocate(pos_x, pos_y);
        newbtn.setText(gameAtt.getDefaultDesc());
        newbtn.setOnAction((ActionEvent event) -> {
            if(gameAtt.getCurrPlayer() >= 0){
            	// Checks to see if button is empty and moves with player if button is not empty
                if(newbtn.getText().equals(gameAtt.getDefaultDesc())){
                    for(int _row = 0; _row<gameAtt.getSize();_row++){
                        for(int _col = 0; _col<gameAtt.getSize();_col++){
                            if(btns.get(_row).get(_col).equals(newbtn)){
                                gameAtt.setAttInfo(_row, _col, gameAtt.getCurrPlayer());		// sets the value of the button which will help us check for winner
                                updateButton(_row,_col);                                        // sets the "text" of the button to the value of the player (0 = X 1 = O)
                                gameAtt.NextPlayer();											// swaps player 0 to player 1 (way of taking turns)
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
            
            // Winner message, displays either if player 1 wins or player 0 wins or if it is a tie
            if(cker.Checkwinner(gameAtt, gameAtt.getPlayer(0))){
                new Alert(Alert.AlertType.INFORMATION, gameAtt.getPlayer(0) + " is winner").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
            else if(cker.Checkwinner(gameAtt, gameAtt.getPlayer(1))){
                new Alert(Alert.AlertType.INFORMATION, gameAtt.getPlayer(1) + " is winner").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
            if(!gameAtt.HasNextMove()){
                new Alert(Alert.AlertType.INFORMATION, "Tie").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
        });
    }        
    
    // AI version of the game where a player plays with an AI
    public void setAIButton(Button newbtn, int size_x, int size_y, int pos_x, int pos_y){
        newbtn.setPrefSize(size_x, size_y);
        newbtn.relocate(pos_x, pos_y);
        newbtn.setText(gameAtt.getDefaultDesc());
        AIMove aimove = new AIMove();
        newbtn.setOnAction((ActionEvent event) -> {
            if(gameAtt.getCurrPlayer() == 0){
                // Checks to see if button is empty and moves with player if button is not empty
                if(newbtn.getText().equals(gameAtt.getDefualtDesc())){
                    for(int _row = 0; _row<gameAtt.getSize();_row++){
                        for(int _col = 0; _col<gameAtt.getSize();_col++){
                            if(btns.get(_row).get(_col).equals(newbtn)){
                                // setting the value of the player move
                                gameAtt.setAttInfo(_row, _col, gameAtt.getCurrPlayer());
                                // Calls the AI move and set the values
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
            if(!gameAtt.HasNextMove()){
                new Alert(Alert.AlertType.INFORMATION, "Tie").showAndWait();
                gameAtt.setCurrPlayer(-1);
            }
        });
    }
}

      

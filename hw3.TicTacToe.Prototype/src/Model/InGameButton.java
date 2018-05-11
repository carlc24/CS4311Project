/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Control.GameAttribute;
import java.util.List;
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
    void updateAllButoon(){
        for(int _row = 0; _row < gameAtt.getSize(); _row++){
            for(int _col = 0; _col < gameAtt.getSize(); _col++){
                btns.get(_row).get(_col).setText(gameAtt.getAttInfo(_row,_col));
            }
        }
    }
    public void setPvPButton(Button newbtn, int size_x, int size_y, int pos_x, int pos_y){
        newbtn.setPrefSize(size_x, size_y);
        newbtn.relocate(pos_x, pos_y);
        newbtn.setText(gameAtt.getDefualtDesc());
        newbtn.setOnAction((ActionEvent event) -> {
            if(gameAtt.getCurrPlayer() >= 0){
                // code start here
                if(newbtn.getText().equals(gameAtt.getDefualtDesc())){
                    for(int _row = 0; _row<gameAtt.getSize();_row++){
                        for(int _col = 0; _col<gameAtt.getSize();_col++){
                            if(btns.get(_row).get(_col).equals(newbtn)){
                                gameAtt.setAttInfo(_row, _col, gameAtt.getCurrPlayer());
                                newbtn.setText(gameAtt.getPlayer(gameAtt.getCurrPlayer()));
                                gameAtt.NextPlayer();
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
            }
            else if(cker.Checkwinner(gameAtt, gameAtt.getPlayer(1))){
                new Alert(Alert.AlertType.INFORMATION, gameAtt.getPlayer(1) + " is winner").showAndWait();
            }
            if(!gameAtt.HasNextMove()){
                gameAtt.setCurrPlayer(-1);
                new Alert(Alert.AlertType.INFORMATION, "Tie").showAndWait();
            }
        });
    }
}

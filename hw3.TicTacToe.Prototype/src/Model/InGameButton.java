/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Control.GameAttribute;
import java.util.List;
import javafx.scene.control.Button;

/**
 *
 * @author verastu
 */
public class InGameButton {
    List<List<Button>> btns;
    GameAttribute gameAtt;
    void updateButton(int _row,int _col){
        btns.get(_row).get(_col).setText(gameAtt.getAttInfo(_row,_col));
    }
    void updateAllButoon(){
        for(int _row = 0; _row < gameAtt.getSize()/3; _row++){
            for(int _col = 0; _col < gameAtt.getSize()/3; _col++){
                btns.get(_row).get(_col).setText(gameAtt.getAttInfo(_row,_col));
            }
        }
    }
}

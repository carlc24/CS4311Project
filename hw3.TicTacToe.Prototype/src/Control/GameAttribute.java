/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author verastu
 */
public class GameAttribute {
    List<List<String>> gameAttInfo;
    String[] player;
    String defDesc;
    int size;
    
    public void initAttInfo(String _player1, String _player2, String _defDesc, int _size){
        this.player = new String[]{_player1,_player2};
        this.defDesc = _defDesc;
        this.size = _size;
        for(int i = 0; i<(size/3);i++){
            List<String> temp = new ArrayList<String>();
            gameAttInfo.add(temp);
            for(int j = 0; j<(size/3);j++){
                gameAttInfo.get(i).add(defDesc);
            }
        }
    }
    public void setAttInfo(int _row, int _col, int _player){
        gameAttInfo.get(_row).set(_col, player[_player]);
    }
    public String getAttInfo(int _row, int _col){
        return gameAttInfo.get(_row).get(_col);
    }
    public String getPlayer(int _player){
        return player[_player];
    }
    public String getDefualtDesc(){
        return defDesc;
    }
    public int getSize(){
        return size;
    }
}

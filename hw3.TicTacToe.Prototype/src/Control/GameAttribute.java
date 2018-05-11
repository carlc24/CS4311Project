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
    int stepCounter;
    int currPlayer;
    
    public void initAttInfo(String _player1, String _player2, String _defDesc, int _size){
        gameAttInfo = new ArrayList<>();
        player = new String[]{_player1,_player2};
        defDesc = _defDesc;
        size = _size;
        stepCounter = 0;
        currPlayer = -1;
        for(int i = 0; i<(size);i++){
            gameAttInfo.add(new ArrayList<String>());
            for(int j = 0; j<(size);j++){
                gameAttInfo.get(i).add(defDesc);
            }
        }
    }
    public void setAttInfo(int _row, int _col, int _player){
        stepCounter++;
        gameAttInfo.get(_row).set(_col, player[_player]);
    }
    public void setCurrPlayer(int _user){
        currPlayer = _user;
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
    public int getCurrPlayer(){
        return currPlayer;
    }
    public int NextPlayer(){
        if(currPlayer == 0){
            currPlayer = 1;
        }
        else if (currPlayer == 1){
            currPlayer = 0;
        }
        return currPlayer;
    }
    public boolean HasNextMove(){
        return stepCounter<(size*size);
    }
}

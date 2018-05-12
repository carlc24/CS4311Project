/**
 * GameAttribute class maintains game related information
 * @author It is created and modifed by Jia Shin Tseng & Carl Chung
 * Last modified in May 11, 2018
 */

package Control;
import java.util.ArrayList;
import java.util.List;
public class GameAttribute {
    // objects
    List<List<String>> gameAttInfo;
    String[] player;
    String defDesc;
    int size;
    int stepCounter;
    int currPlayer;
    
    /** Function: initAttInfo
     * @Comment: Use user defined information to start the program
     * @Pre: n/a
     * @Post: n/a
     */
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
    /** Function: setAttInfo
     * @Comment: when user making a move, it will properly change the cell information
     * @Pre: n/a
     * @Post: n/a
     */
    public void setAttInfo(int _row, int _col, int _player){
        stepCounter++;
        gameAttInfo.get(_row).set(_col, player[_player]);
    }
    
    /** Function: setCurrPlayer
     * @Comment: current player
     * @Pre: _user must be in the range of the number of the players
     * @Post: n/a
     */
    public void setCurrPlayer(int _user){
        currPlayer = _user;
    }
    
    /** Function: getAttInfo
     * @Comment: return a cell attribute
     * @Pre: n/a
     * @Post: n/a
     */
    public String getAttInfo(int _row, int _col){
        return gameAttInfo.get(_row).get(_col);
    }
    
    /** Function: getPlayer
     * @Comment: return the player String
     * @Pre: n/a
     * @Post: n/a
     */
    public String getPlayer(int _player){
        return player[_player];
    }
    
    /** Function: getDefualtDesc
     * @Comment: return default player String
     * @Pre: n/a
     * @Post: n/a
     */
    public String getDefualtDesc(){
        return defDesc;
    }
    
    /** Function: getSize
     * @Comment: return the size of the map
     * @Pre: n/a
     * @Post: n/a
     */
    public int getSize(){
        return size;
    }
    
    /** Function: getCurrPlayer
     * @Comment: return the integer of current player 
     * @Pre: n/a
     * @Post: n/a
     */
    public int getCurrPlayer(){
        return currPlayer;
    }
    
    /** Function: NextPlayer
     * @Comment: change to next player and return the integer of next player 
     * @Pre: n/a
     * @Post: n/a
     */
    public int NextPlayer(){
        if(currPlayer == 0){
            currPlayer = 1;
        }
        else if (currPlayer == 1){
            currPlayer = 0;
        }
        return currPlayer;
    }
    
    /** Function: HasNextMove
     * @Comment: check if there are still available cells for play
     * @Pre: n/a
     * @Post: n/a
     */
    public boolean HasNextMove(){
        return stepCounter<(size*size);
    }
}

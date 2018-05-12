/**
 * AIMove class support the logical thinking of AI's decision
 * @author It is created and modifed by Jia Shin Tseng & Carl Chung
 * Last modified in May 11, 2018
 */

package Control;
import java.util.Random;
public class AIMove {
    // class objects
    Random ranNumber = new Random();
    /** Function: EasyMove
     * @Comment: return position and modified the available free cell for AI
     * @Pre: n/a
     * @Post: n/a
     */
    public int[] EasyMove(GameAttribute gameatt){
        int randomNumberRow = ranNumber.nextInt(gameatt.getSize());
        int randomNumberCol = ranNumber.nextInt(gameatt.getSize());
        if(gameatt.HasNextMove() ){
            while(!gameatt.getAttInfo(randomNumberRow, randomNumberCol).equals(gameatt.getDefualtDesc())){
                randomNumberRow = ranNumber.nextInt(gameatt.getSize());
                randomNumberCol = ranNumber.nextInt(gameatt.getSize());
            }
            // "1 " is player_2(AI)
            gameatt.setAttInfo(randomNumberRow, randomNumberCol, 1);
        }
        return new int[] {randomNumberRow,randomNumberCol};
    }
}

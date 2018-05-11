/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Random;

/**
 *
 * @author Tom
 */
public class AIMove {
	// AI is random movements for now, if extra time we will improve the AI.
    Random ranNumber = new Random();
    public int[] EasyMove(GameAttribute gameatt){
        int randomNumberRow = ranNumber.nextInt(gameatt.getSize());
        int randomNumberCol = ranNumber.nextInt(gameatt.getSize());
        if(gameatt.HasNextMove() ){
            while(!gameatt.getAttInfo(randomNumberRow, randomNumberCol).equals(gameatt.getDefaultDesc())){	// As long as there are moves that can be made, AI will make moves
                randomNumberRow = ranNumber.nextInt(gameatt.getSize());		
                randomNumberCol = ranNumber.nextInt(gameatt.getSize());
            }
            
            gameatt.setAttInfo(randomNumberRow, randomNumberCol, 1);		// sets the attribute information of the button to the random number of player 1 which would be the AI in this instance
        }
        return new int[] {randomNumberRow,randomNumberCol};			
    }
}

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
    Random ranNumber = new Random();
    int[] EasyMove(GameAttribute gameatt){
        int randomNumberRow = ranNumber.nextInt(gameatt.getSize());
        int randomNumberCol = ranNumber.nextInt(gameatt.getSize());
        if(gameatt.HasNextMove() ){
            while(!gameatt.getAttInfo(randomNumberRow, randomNumberCol).equals(gameatt.getDefualtDesc())){
                randomNumberRow = ranNumber.nextInt(gameatt.getSize());
                randomNumberCol = ranNumber.nextInt(gameatt.getSize());
            }
            // player_2 is AI
            gameatt.setAttInfo(randomNumberRow, randomNumberCol, 1);
        }
        return new int[] {randomNumberRow,randomNumberCol};
    }
}

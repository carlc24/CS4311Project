/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import Control.AttributeIterator;
import Control.AttributeIterator.LDemIterator;
import Control.AttributeIterator.RDemIterator;
import Control.AttributeIterator.RowIterator;
import Control.AttributeIterator.ColIterator;
import Control.GameAttribute;

/**
 *
 * @author verastu
 */
public class UniqueChecker {
	
	//Iterating rows
    boolean SameValues(RowIterator it, String user){
        while(it.hasNext()){
            if(!it.next().equals(user))
                return false;
        }
        return true;
    }
    //Iterating Columns
    boolean SameValues(ColIterator it, String user){
        while(it.hasNext()){
            if(!it.next().equals(user))
                return false;
        }
        return true;
    }
    // Iterating right Diagonals
    boolean SameValues(RDemIterator it, String user){
        while(it.hasNext()){
            if(!it.next().equals(user))
                return false;
        }
        return true;
    }
    
    // Iterating left Diagonals
    boolean SameValues(LDemIterator it, String user){
        while(it.hasNext()){
            if(!it.next().equals(user))
                return false;
        }
        return true;
    }
    
    //Checking for matches, uses the iterators to iterate and checks to see if someone has 3 in a row.
    public boolean Checkwinner(GameAttribute gameAtt, String user){
        AttributeIterator attIter = new AttributeIterator(gameAtt);
        for(int i = 0; i<(gameAtt.getSize()); i++){
            if(SameValues(attIter.getRowIterator(i),user))
                return true;
            if(SameValues(attIter.getColIterator(i),user))
                return true;
        }
        if(SameValues(attIter.getRDemIterator(),user))
                return true;
        if(SameValues(attIter.getLDemIterator(),user))
                return true;
        return false;
    }
}

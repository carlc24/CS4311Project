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
    boolean SameValues(RowIterator it, String user){
        while(it.hasNext()){
            if(!it.next().equals(user))
                return false;
        }
        return true;
    }
    boolean SameValues(ColIterator it, String user){
        while(it.hasNext()){
            if(!it.next().equals(user))
                return false;
        }
        return true;
    }
    boolean SameValues(RDemIterator it, String user){
        while(it.hasNext()){
            if(!it.next().equals(user))
                return false;
        }
        return true;
    }
    boolean SameValues(LDemIterator it, String user){
        while(it.hasNext()){
            if(!it.next().equals(user))
                return false;
        }
        return true;
    }
    boolean Checkwinner(GameAttribute gameAtt, String user){
        AttributeIterator attIter = new AttributeIterator(gameAtt);
        for(int i = 0; i<(gameAtt.getSize()/3); i++){
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

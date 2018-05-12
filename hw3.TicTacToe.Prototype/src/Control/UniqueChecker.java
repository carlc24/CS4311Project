/**
 * Unique checker class allows the players the compares the values in rows, columns, and diagonals
 * @author It is created and modifed by Jia Shin Tseng & Carl Chung
 * Last modified in May 11, 2018
 */

package Control;
import Control.AttributeIterator.*;
public class UniqueChecker {
    /** Function: sameValues
     * @Comment: Iterating rows,columns, or diagonal lines.
     * @Pre: The Iterator parameter must be initialized, and defined
     * @Post: n/a
     */
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
    /** Function: Checkwinner
     * @Comment: Checking for matches, uses the iterators to iterate and checks to see if someone has 3 in a row.
     * @Pre: The Iterator parameter must be initialized, and defined
     * @Post: n/a
     */
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

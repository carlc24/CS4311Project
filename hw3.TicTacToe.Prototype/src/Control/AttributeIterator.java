/**
 * AttributeIterator class support the iterating of cells' inforamtion
 * @author It is created and modifed by Jia Shin Tseng & Carl Chung
 * Last modified in May 11, 2018
 */

package Control;
import java.util.Iterator;
public class AttributeIterator {
    // objects
    GameAttribute gameAtt;
    
    /** Function: AttributeIterator
     * @Comment: constructor
     * @Pre: _gameAtt must be predefined
     * @Post: n/a
     */
    public AttributeIterator(GameAttribute _gameAtt){
        gameAtt = _gameAtt;
    }
    
    /** Function: Getter
     * @Comment: return designed iterator for iterating
     * @Pre: n/a
     * @Post: n/a
     */
    public RowIterator getRowIterator(int _row){
        return new RowIterator(_row);
    }
    public ColIterator getColIterator(int _col){
        return new ColIterator(_col);
    }
    public RDemIterator getRDemIterator(){
        return new RDemIterator();
    }
    public LDemIterator getLDemIterator(){
        return new LDemIterator();
    }
    
    /** Function: Iterator classes' implementation
     * @Comment: Iterators
     * @Pre: n/a
     * @Post: n/a
     */
    public class RowIterator implements Iterator<String>{
        private int count;
        private int row;
        public RowIterator(int _row){
            count = 0;
            row = _row;
        }

        @Override
        public boolean hasNext() {
            return count < (gameAtt.getSize());
        }

        @Override
        public String next() {
            return (gameAtt.getAttInfo(row,count++));
        }
    }
    public class ColIterator implements Iterator<String>{
        private int count;
        private int col;
        ColIterator(int _col){
            count = 0;
            col = _col;
        }

        @Override
        public boolean hasNext() {
            return count < (gameAtt.getSize());
        }

        @Override
        public String next() {
            return (gameAtt.getAttInfo(count++,col));
        }
    }
    public class RDemIterator implements Iterator<String>{
        private int count;
        private int reverse;
        RDemIterator(){
            count = 0;
            reverse = gameAtt.getSize();
        }

        @Override
        public boolean hasNext() {
            return count < (gameAtt.getSize());
        }
        @Override
        public String next() {
            return (gameAtt.getAttInfo(count++, reverse - count));
        }
    }
    public class LDemIterator implements Iterator<String>{
        private int count;
        public String user;
        LDemIterator(){
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < (gameAtt.getSize());
        }
        @Override
        public String next() {
            return gameAtt.getAttInfo(count, count++);
        }
    }
}

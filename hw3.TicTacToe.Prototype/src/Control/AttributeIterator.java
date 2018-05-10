/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.util.Iterator;

/**
 *
 * @author verastu
 */
public class AttributeIterator {
    GameAttribute gameAtt;
    public AttributeIterator(GameAttribute _gameAtt){
        gameAtt = _gameAtt;
    }
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
    public class RowIterator implements Iterator<String>{
        private int count;
        private int row;
        public RowIterator(int _row){
            count = 0;
            row = _row;
        }

        @Override
        public boolean hasNext() {
            return count < (gameAtt.getSize()/3);
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
            return count < (gameAtt.getSize()/3);
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
            return count < (gameAtt.getSize()/3);
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
            return count < (gameAtt.getSize()/3);
        }
        @Override
        public String next() {
            return gameAtt.getAttInfo(count, count++);
        }
    }
}

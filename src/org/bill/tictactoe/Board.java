package org.bill.tictactoe;

import com.google.common.base.Predicate;

import java.util.ArrayList;
import java.util.List;

import static org.bill.tictactoe.Mark.*;
import static org.bill.tictactoe.Lists2.filter;

public class Board {

    private final List<Cell> cells = new ArrayList<Cell>();

    public Board() {
        for (int i=0;i<9;i++){
            cells.add(new Cell(i, EMPTY));
        }
    }

    public String toString(){
        String board = "";
        board += row(0);
        board += bar();
        board += row(1);
        board += bar();
        board += row(2);
        return board;
    }

    private String bar() {
        return "-----\n";
    }

    private String row(int row) {
        return cells.get(row*3 + 0) + "|" + cells.get(row*3 + 1)+"|"+ cells.get(row*3 + 2) + "\n";
    }

    public List<Cell> emptyCells() {
        return filter(cells, new IsCellEmpty());
    }

    public void print() {
        System.out.println(toString());
    }

    public Cell cell(int i) {
        return cells.get(i);
    }

    private static class IsCellEmpty implements Predicate<Cell> {
        public boolean apply(Cell cell) {
            return cell.is(Mark.EMPTY);
        }
    }
}

package org.bill.tictactoe.board;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.bill.tictactoe.Lists2.filter;
import static org.bill.tictactoe.Predicates.IsCellEmpty;

public class Board {

    private Cell center;
    private Cell[] corners = new Cell[4];
    private Cell[] sides = new Cell[4];

    private final List<Cell> cells = new ArrayList<Cell>();

    public Board() {
        for (int i=0;i<9;i++){
            cells.add(new Cell(Mark.EMPTY));
        }
        center = cells.get(4);
        newArrayList(cells.get(0), cells.get(2), cells.get(6), cells.get(8)).toArray(corners);
        newArrayList(cells.get(1), cells.get(3), cells.get(5), cells.get(7)).toArray(sides);
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
        return cells.get(row*3) + "|" + cells.get(row*3 + 1)+"|"+ cells.get(row*3 + 2) + "\n";
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

    public Cell center() {
        return center;
    }

    public Cell[] corners() {
        return corners;
    }

    public Cell[] sides() {
        return sides;
    }
}

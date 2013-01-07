package org.bill.tictactoe;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;
import static org.bill.tictactoe.Cell.CellState.EMPTY;
import static org.bill.tictactoe.Cell.CellState.O;
import static org.bill.tictactoe.Cell.CellState.X;
import static org.bill.tictactoe.Lists2.filter;

public class Board {

    private final List<Cell> cells = new ArrayList<Cell>();
    private List<CellTuple> triples;

    public Board() {
        for (int i=0;i<9;i++){
            cells.add(new Cell(i, EMPTY));
        }
        triples = new ImmutableList.Builder<CellTuple>()
                    .add(cells(0, 1, 2))
                    .add(cells(3, 4, 5))
                    .add(cells(6, 7, 8))
                    .add(cells(0, 3, 6))
                    .add(cells(1, 4, 7))
                    .add(cells(2, 5, 8))
                    .add(cells(0, 4, 8))
                    .add(cells(2, 4, 6))
                    .build();
    }

    private CellTuple cells(int i, int j, int k) {
        return new CellTuple(cells.get(i), cells.get(j), cells.get(k));
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

    public boolean won() {
        return checkForWinByPlayer(X) || checkForWinByPlayer(O);
    }

    private boolean checkForWinByPlayer(final Cell.CellState player) {
        int numberOfWins = filter(triples, new IsThreeInARow(player)).size();
        return numberOfWins > 0;
    }

    public List<Cell> emptyCells() {
        return filter(cells, new IsCellEmpty());
    }

    private static class IsCellEmpty implements Predicate<Cell> {
        public boolean apply(Cell cell) {
            return cell.is(Cell.CellState.EMPTY);
        }
    }

    private static class IsThreeInARow implements Predicate<CellTuple> {
        private final Cell.CellState player;

        public IsThreeInARow(Cell.CellState player) {
            this.player = player;
        }

        public boolean apply(CellTuple cellTuple) {
            return cellTuple.isAll(player);
        }
    }
}

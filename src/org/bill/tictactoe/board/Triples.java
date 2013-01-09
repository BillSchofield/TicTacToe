package org.bill.tictactoe.board;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import org.bill.tictactoe.player.Player;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static org.bill.tictactoe.Lists2.filter;
import static org.bill.tictactoe.Predicates.Contains;
import static org.bill.tictactoe.Predicates.IsThreeInARow;

public class Triples {
    private Board board;
    private List<CellTuple> triples;
    private final List<CellTuple> rows;
    private final List<CellTuple> columns;
    private final List<CellTuple> diagonals;

    public Triples(Board board) {
        this.board = board;
        rows = newArrayList(cells(0, 1, 2), cells(3, 4, 5), cells(6, 7, 8));
        columns = newArrayList(cells(0, 3, 6), cells(1, 4, 7), cells(2, 5, 8));
        diagonals = newArrayList(cells(0, 4, 8), cells(2, 4, 6));
        triples = new ImmutableList.Builder<CellTuple>()
                    .addAll(rows)
                    .addAll(columns)
                    .addAll(diagonals)
                    .build();
    }

    public boolean won(Player player) {
        return has(new IsThreeInARow(player));
    }

    private CellTuple cells(int i, int j, int k) {
        return new CellTuple(board.cell(i), board.cell(j), board.cell(k));
    }

    public boolean has(Predicate<CellTuple> predicate) {
        return !filter(triples, predicate).isEmpty();
    }

    public boolean hasAtLeastTwoContainingCell(final Cell cell, Predicate<CellTuple> predicate) {
        List<CellTuple> triplesContainingCell = filter(triples, new Contains(cell));
        return filter(triplesContainingCell, predicate).size() > 1;
    }

    public Cell getCellWith(Predicate<CellTuple> predicate) {
        List<CellTuple> winningCells = filter(triples, predicate);
        return winningCells.get(0).emptyCell();
    }

    public boolean gameOver(Player player) {
        return won(player) || board.emptyCells().size() == 0;
    }

    public List<Cell> cellsFromDiagonalsWith(Predicate<CellTuple> predicate) {
        return transform(filter(diagonals, predicate), new EmptyCellFromTuple());
    }

    private static class EmptyCellFromTuple implements Function<CellTuple, Cell> {
        public Cell apply(CellTuple cellTuple) {
            return cellTuple.emptyEndCell();
        }
    }
}

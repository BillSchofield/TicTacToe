package org.bill.tictactoe.board;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import org.bill.tictactoe.player.Player;

import java.util.List;

import static org.bill.tictactoe.Lists2.filter;
import static org.bill.tictactoe.Predicates.Contains;
import static org.bill.tictactoe.Predicates.IsThreeInARow;

public class Triples {
    private Board board;
    private List<CellTuple> triples;

    public Triples(Board board) {
        this.board = board;
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
}

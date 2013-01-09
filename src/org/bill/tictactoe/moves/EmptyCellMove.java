package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.player.Player;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.bill.tictactoe.Lists2.filter;
import static org.bill.tictactoe.Predicates.ThatAreEmpty;

public class EmptyCellMove implements Move {
    private final List<Cell> cells;
    private final ThatAreEmpty thatAreEmpty = new ThatAreEmpty();

    public EmptyCellMove(Cell... cells) {
        this.cells = newArrayList(cells);
    }

    public Cell go(Player player) {
        return emptyCandidateCells().get(0);
    }

    public boolean canGo(Player player) {
        return !emptyCandidateCells().isEmpty();
    }

    private List<Cell> emptyCandidateCells() {
        return filter(cells, thatAreEmpty);
    }
}

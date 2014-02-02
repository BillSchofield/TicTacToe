package org.bill.tictactoe.board;

import com.google.common.base.Predicate;
import org.bill.tictactoe.Lists2;
import org.bill.tictactoe.Predicates.BelongingTo;
import org.bill.tictactoe.Predicates.ThatAreEmpty;
import org.bill.tictactoe.player.Player;

import java.util.List;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.newArrayList;
import static org.bill.tictactoe.Lists2.filter;
import static org.bill.tictactoe.player.Player.NO_ONE;

public class CellTuple {
    private final List<Cell> cells;
    private final List<Cell> endCells;

    public CellTuple(Cell... cells) {
        this.cells = newArrayList(cells);
        endCells = newArrayList(get(this.cells, 0), getLast(this.cells));
    }

    public boolean isAll(Player player) {
        return cellsOwnedBy(player) == 3;
    }

    private int cellsOwnedBy(final Player player) {
        return filter(cells, new BelongingTo(player)).size();
    }

    public boolean hasEmptyCellAndTwo(Player player) {
        return cellsOwnedBy(player) == 2 && cellsOwnedBy(NO_ONE) == 1;
    }

    public boolean hasTwoEmptyCellsAnd(Player player) {
        return cellsOwnedBy(player) == 1 && cellsOwnedBy(NO_ONE) == 2;
    }

    public Cell emptyCell() {
        return find(cells, new ThatAreEmpty());
    }

    public boolean contains(Cell cell) {
        return cells.contains(cell);
    }

    public Cell emptyEndCell() {
        return find(endCells, new ThatAreEmpty());
    }

    public boolean hasEmptyCornerAndCornerOwnedBy(Player player) {
        return hasAtLeastOneCell(new ThatAreEmpty()) && hasAtLeastOneCell(new BelongingTo(player));
    }

    private boolean hasAtLeastOneCell(Predicate<Cell> predicate) {
        return !Lists2.filter(endCells, predicate).isEmpty();
    }
}

package org.bill.tictactoe.board;

import com.google.common.base.Predicate;
import org.bill.tictactoe.player.Player;

import java.util.List;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;
import static org.bill.tictactoe.Lists2.filter;
import static org.bill.tictactoe.Predicates.IsCellEmpty;
import static org.bill.tictactoe.player.Player.NO_ONE;

public class CellTuple {
    private final List<Cell> cells;

    public CellTuple(Cell... cells) {
        this.cells = newArrayList(cells);
    }

    public boolean isAll(Player player) {
        return cellsMarkedBy(player) == 3;
    }

    private int cellsMarkedBy(final Player player) {
        List<Cell> cellsInDesiredState = filter(cells, new Predicate<Cell>() {
            public boolean apply(Cell cell) {
                return cell.isMarkedBy(player);
            }
        });
        return cellsInDesiredState.size();
    }

    public boolean hasEmptyCellAndTwo(Player player) {
        return cellsMarkedBy(player) == 2 && cellsMarkedBy(NO_ONE) == 1;
    }

    public boolean hasTwoEmptyCellsAnd(Player player) {
        return cellsMarkedBy(player) == 1 && cellsMarkedBy(NO_ONE) == 2;
    }

    public Cell emptyCell() {
        return find(cells, new IsCellEmpty());
    }

    public boolean contains(Cell cell) {
        return cells.contains(cell);
    }
}

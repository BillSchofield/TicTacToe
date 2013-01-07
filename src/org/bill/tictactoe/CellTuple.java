package org.bill.tictactoe;

import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;
import static org.bill.tictactoe.Lists2.filter;

public class CellTuple {
    private final List<Cell> cells;

    public CellTuple(Cell... cells) {
        this.cells = newArrayList(cells);
    }

    public boolean isAll(final Mark mark) {
        return cellsWithMark(mark) == 3;
    }

    private int cellsWithMark(final Mark mark) {
        List<Cell> cellsInDesiredState = filter(cells, new Predicate<Cell>() {
            public boolean apply(Cell cell) {
                return cell.is(mark);
            }
        });
        return cellsInDesiredState.size();
    }

    public boolean hasEmptyCellAndTwo(Mark mark) {
        return cellsWithMark(mark) == 2 && cellsWithMark(Mark.EMPTY) == 1;
    }

    public Cell emptyCell() {
        return find(cells, new Predicate<Cell>() {
            public boolean apply(Cell cell) {
                return cell.is(Mark.EMPTY);
            }
        });
    }
}

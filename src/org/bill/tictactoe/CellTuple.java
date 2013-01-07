package org.bill.tictactoe;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static org.bill.tictactoe.Cell.CellState;

public class CellTuple {
    private final Set<Cell> cells;

    public CellTuple(Cell... cells) {
        this.cells = newHashSet(cells);
    }

    public boolean isAll(final CellState state) {
        Set<Cell> cellsInDesiredState = newHashSet(Iterables.filter(cells, new Predicate<Cell>() {
            public boolean apply(Cell cell) {
                return cell.is(state);
            }
        }));
        return cellsInDesiredState.size() == 3;
    }
}

package org.bill.tictactoe;

import java.util.List;
import java.util.Random;

public class RandomMove implements Move {
    public void go(Board board, Mark mark) {
        List<Cell> emptyCells = board.emptyCells();
        emptyCells.get(new Random().nextInt(emptyCells.size())).setState(mark);
    }

    public boolean canGo(Mark mark) {
        return true;
    }
}

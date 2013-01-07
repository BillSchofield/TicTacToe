package org.bill.tictactoe;

import java.util.List;
import java.util.Random;

public class RandomStrategy extends Strategy {
    RandomMove move = new RandomMove();

    public RandomStrategy(Board board) {
        super(board);
    }

    public void go(Mark mark) {
        move.go(board, mark);
    }
}

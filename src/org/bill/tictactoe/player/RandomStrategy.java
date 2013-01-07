package org.bill.tictactoe.player;

import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.moves.RandomMove;

public class RandomStrategy extends Strategy {
    RandomMove move;

    public RandomStrategy(Board board) {
        super(board);
        move = new RandomMove(board);
    }

    public void go(Player player) {
        move.go(player);
    }
}

package org.bill.tictactoe.player;

import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.moves.RandomMove;

public class RandomStrategy implements Strategy {
    RandomMove move;

    public RandomStrategy(Board board) {
        move = new RandomMove(board);
    }

    public Cell findMove(Player player) {
        return move.go(player);
    }
}

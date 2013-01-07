package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.player.Player;

import java.util.List;
import java.util.Random;

public class RandomMove implements Move {
    public RandomMove(Board board) {
        this.board = board;
    }

    private Board board;

    public void go(Player player) {
        List<Cell> emptyCells = board.emptyCells();
        player.makeMarkIn(emptyCells.get(new Random().nextInt(emptyCells.size())));
    }

    public boolean canGo(Player player) {
        return true;
    }
}

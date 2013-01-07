package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.player.Player;

import static org.bill.tictactoe.player.Player.NO_ONE;

public class PlayCenterMove implements Move {
    public static final int CENTER = 4;
    private Board board;

    public PlayCenterMove(Board board) {
        this.board = board;
    }

    public void go(Player player) {
        player.makeMarkIn(board.cell(CENTER));
    }

    public boolean canGo(Player player) {
        return board.cell(CENTER).isMarkedBy(NO_ONE);
    }
}

package org.bill.tictactoe.player;

import org.bill.tictactoe.board.Board;

public abstract class Strategy {
    protected Board board;

    public Strategy(Board board) {
        this.board = board;
    }

    public abstract void go(Player player);
}

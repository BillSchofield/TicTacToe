package org.bill.tictactoe;

public abstract class Strategy {
    protected Board board;

    public Strategy(Board board) {
        this.board = board;
    }

    public abstract void go(Mark mark);
}

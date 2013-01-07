package org.bill.tictactoe;

public class ForkMove implements Move {
    public void go(Board board, Mark mark) {
    }

    public boolean canGo(Mark mark) {
        return false;
    }
}

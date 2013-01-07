package org.bill.tictactoe;

public interface Move {
    public void go(Board board, Mark mark);
    boolean canGo(Mark mark);
}

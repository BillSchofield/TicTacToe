package org.bill.tictactoe.player;

import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.board.Mark;

public class Player {
    public static final Player NO_ONE = new Player(Mark.EMPTY, null);
    private final Mark mark;
    private final Strategy strategy;
    private Player otherPlayer;

    public Player(Mark mark, Strategy strategy) {
        this.mark = mark;
        this.strategy = strategy;
    }

    public Player otherPlayer() {
        return this.otherPlayer;
    }

    public void otherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public void move() {
        strategy.go(this);
    }

    public void makeMarkIn(Cell cell) {
        cell.make(mark);
    }

    public boolean hasMark(Mark mark) {
        return this.mark.equals(mark);
    }
}

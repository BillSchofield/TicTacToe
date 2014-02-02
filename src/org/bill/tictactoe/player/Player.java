package org.bill.tictactoe.player;

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

    public Player opponent() {
        return this.otherPlayer;
    }

    public void opponent(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public void move() {
        strategy.findMove(this).make(mark);
    }

    public boolean hasMark(Mark mark) {
        return this.mark.equals(mark);
    }
}

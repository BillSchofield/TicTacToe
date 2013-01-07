package org.bill.tictactoe;

public class Player {
    private Mark mark;
    private Strategy strategy;
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
        strategy.go(mark);
    }
}

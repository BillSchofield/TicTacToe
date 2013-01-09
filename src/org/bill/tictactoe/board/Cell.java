package org.bill.tictactoe.board;

import org.bill.tictactoe.player.Player;

public class Cell {
    private Mark state;

    public Cell(Mark state) {
        this.state = state;
    }

    public boolean isMarkedBy(Player player) {
        return player.hasMark(this.state);
    }

    public void make(Mark state) {
        this.state = state;
    }

    public String toString(){
        return state.toString();
    }
}

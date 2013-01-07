package org.bill.tictactoe;

import static org.bill.tictactoe.Cell.CellState.EMPTY;

public class Cell {
    private int index;

    public static enum CellState{
        EMPTY(" "), X("X"), O("O");
        private String string;
        private CellState otherPlayer;

        private CellState(String string) {
            this.string = string;
        }

        public String toString(){
            return string;
        }

        public CellState otherPlayer() {
            return this.otherPlayer;
        }

        public void otherPlayer(CellState otherPlayer) {
            this.otherPlayer = otherPlayer;
        }
    }
    private CellState state;

    public Cell(int index, CellState state) {
        this.index = index;
        this.state = state;
    }

    public boolean is(CellState state) {
        return this.state.equals(state);
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public String toString(){
        return state.toString();
    }
}

package org.bill.tictactoe;

public class Cell {
    private int index;


    private Mark state;

    public Cell(int index, Mark state) {
        this.index = index;
        this.state = state;
    }

    public boolean is(Mark state) {
        return this.state.equals(state);
    }

    public void setState(Mark state) {
        this.state = state;
    }

    public String toString(){
        return state.toString();
    }
}

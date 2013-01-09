package org.bill.tictactoe.board;

public enum Mark {
    EMPTY(" "), X("X"), O("O");
    private String string;

    private Mark(String string) {
        this.string = string;
    }

    public String toString(){
        return string;
    }
}
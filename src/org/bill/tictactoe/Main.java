package org.bill.tictactoe;


import java.util.List;
import java.util.Random;

import static org.bill.tictactoe.Cell.CellState;
import static org.bill.tictactoe.Cell.CellState.O;
import static org.bill.tictactoe.Cell.CellState.X;

public class Main {

    public static void main(String[] args) {
        Random rng = new Random();
        Board board = new Board();
        X.otherPlayer(O);
        O.otherPlayer(X);

        CellState currentPlayer = X;
        while (!board.won() && board.emptyCells().size() > 0){
            List<Cell> emptyCells = board.emptyCells();
            emptyCells.get(rng.nextInt(emptyCells.size())).setState(currentPlayer);
            currentPlayer = currentPlayer.otherPlayer();
            print(board);
        }
    }

    private static void print(Board board) {
        System.out.println(board);
    }
}

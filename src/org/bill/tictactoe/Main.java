package org.bill.tictactoe;


import static org.bill.tictactoe.Mark.O;
import static org.bill.tictactoe.Mark.X;


public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Triples triples = new Triples(board);
        Player x = new Player(X, new AiStrategy(board, triples));
        Player o = new Player(O, new RandomStrategy(board));
        x.otherPlayer(o);
        o.otherPlayer(x);

        Player currentPlayer = o;
        while (!gameWon(board, triples)){
            currentPlayer = currentPlayer.otherPlayer();
            currentPlayer.move();
            board.print();
        }
    }

    private static boolean gameWon(Board board, Triples triples) {
        return triples.won() && board.emptyCells().size() > 0;
    }
}

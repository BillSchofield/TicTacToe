package org.bill.tictactoe;


import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.player.AiStrategy;
import org.bill.tictactoe.player.Player;
import org.bill.tictactoe.player.RandomStrategy;

import static org.bill.tictactoe.board.Mark.O;
import static org.bill.tictactoe.board.Mark.X;


public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Triples triples = new Triples(board);
        Player x = new Player(X, new AiStrategy(board, triples));
        Player o = new Player(O, new RandomStrategy(board));
        x.otherPlayer(o);
        o.otherPlayer(x);

        Player currentPlayer = o;
        while (!triples.gameOver(currentPlayer)){
            currentPlayer = currentPlayer.otherPlayer();
            currentPlayer.move();
            board.print();
        }
    }

}

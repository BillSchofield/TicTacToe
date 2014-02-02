package org.bill.tictactoe;

import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.player.AiStrategy;
import org.bill.tictactoe.player.Player;
import org.bill.tictactoe.player.RandomStrategy;

import static org.bill.tictactoe.board.Mark.O;
import static org.bill.tictactoe.board.Mark.X;

public class Game {

    private final Board board = new Board();
    private final Triples triples = new Triples(board);
    private final Player x = new Player(X, new RandomStrategy(board));
    private final Player o = new Player(O, new AiStrategy(board, triples));
    private Player currentPlayer = o;

    public Game(){
        x.opponent(o);
        o.opponent(x);
    }

    public void play() {
        while (!triples.gameOver(currentPlayer)){
            currentPlayer = currentPlayer.opponent();
            currentPlayer.move();
            board.print();
        }
    }
}

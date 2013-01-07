package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.player.Player;

public class BlockMove implements Move {
    private Board board;
    private Triples triples;

    public BlockMove(Board board, Triples triples) {
        this.board = board;
        this.triples = triples;
    }

    public void go(Player player) {
    }

    public boolean canGo(Player player) {
        return triples.has(new Triples.AvailableThreeInARow(player));
    }
}

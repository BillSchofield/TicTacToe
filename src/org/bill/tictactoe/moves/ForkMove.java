package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.player.Player;

import java.util.List;

import static org.bill.tictactoe.Lists2.filter;
import static org.bill.tictactoe.Predicates.IsFork;

public class ForkMove implements Move {
    Board board;
    Triples triples;

    public ForkMove(Board board, Triples triples) {
        this.board = board;
        this.triples = triples;
    }

    public Cell go(Player player) {
        return forks(player, triples).get(0);
    }

    public boolean canGo(final Player player) {
        return forks(player, triples).size() > 0;
    }

    private List<Cell> forks(final Player player, final Triples triples) {
        return filter(board.emptyCells(), new IsFork(triples, player));
    }
}

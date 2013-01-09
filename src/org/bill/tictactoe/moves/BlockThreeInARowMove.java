package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.player.Player;

import static org.bill.tictactoe.Predicates.AvailableThreeInARow;


public class BlockThreeInARowMove implements Move {
    private Triples triples;

    public BlockThreeInARowMove(Triples triples) {
        this.triples = triples;
    }

    public Cell go(Player player) {
        return triples.getCellWith(new AvailableThreeInARow(player.otherPlayer()));
    }

    public boolean canGo(Player player) {
        return triples.has(new AvailableThreeInARow(player.otherPlayer()));
    }
}

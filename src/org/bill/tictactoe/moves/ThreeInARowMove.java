package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.player.Player;

import static org.bill.tictactoe.Predicates.AvailableThreeInARow;

public class ThreeInARowMove implements Move {
    private final Triples triples;

    public ThreeInARowMove(Triples triples) {
        this.triples = triples;
    }

    public Cell go(Player player) {
        return triples.getCellWith(new AvailableThreeInARow(player));
    }

    public boolean canGo(final Player player) {
        return triples.has(new AvailableThreeInARow(player));
    }
}

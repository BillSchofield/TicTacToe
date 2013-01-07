package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.player.Player;

import static org.bill.tictactoe.board.Triples.AvailableThreeInARow;

public class ThreeInARowMove implements Move {
    private final Triples triples;

    public ThreeInARowMove(Triples triples) {
        this.triples = triples;
    }

    public void go(Player player) {
        player.makeMarkIn(triples.getCellWith(new AvailableThreeInARow(player)));
    }

    public boolean canGo(final Player player) {
        return triples.has(new AvailableThreeInARow(player));
    }

}

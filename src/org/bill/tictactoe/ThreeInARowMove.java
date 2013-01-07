package org.bill.tictactoe;

import static org.bill.tictactoe.Triples.AvailableThreeInARow;

public class ThreeInARowMove implements Move {
    private final Triples triples;

    public ThreeInARowMove(Triples triples) {
        this.triples = triples;
    }

    public void go(Board board, Mark mark) {
        triples.getCellWith(new AvailableThreeInARow(mark)).setState(mark);
    }

    public boolean canGo(final Mark mark) {
        return triples.has(new AvailableThreeInARow(mark));
    }

}

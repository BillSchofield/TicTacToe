package org.bill.tictactoe.moves;

import com.google.common.base.Predicate;
import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.board.CellTuple;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.player.Player;

import java.util.List;

public class PlayOppositeCornerMove implements Move {
    Triples triples;

    public PlayOppositeCornerMove(Triples triples) {
        this.triples = triples;
    }

    public Cell go(Player player) {
        return cellsInOppositeCornerFromOpponent(player).get(0);
    }

    public boolean canGo(Player player) {
        return cellsInOppositeCornerFromOpponent(player).size() > 0;
    }

    private List<Cell> cellsInOppositeCornerFromOpponent(final Player player) {
        return triples.cellsFromDiagonalsWith(new EmptyCornerAndOpponentOwnedCorner(player));
    }

    private static class EmptyCornerAndOpponentOwnedCorner implements Predicate<CellTuple> {
        private final Player player;

        public EmptyCornerAndOpponentOwnedCorner(Player player) {
            this.player = player;
        }

        public boolean apply(CellTuple cellTuple) {
            return cellTuple.hasEmptyCornerAndCornerOwnedBy(player.opponent());
        }
    }
}

package org.bill.tictactoe;

import com.google.common.base.Predicate;
import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.board.CellTuple;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.moves.Move;
import org.bill.tictactoe.player.Player;

import static org.bill.tictactoe.player.Player.NO_ONE;

public class Predicates {
    public static class ThatAreEmpty implements Predicate<Cell>{
        public boolean apply(Cell cell) {
            return cell.isMarkedBy(NO_ONE);
        }
    }

    private static class PotentialTwoInARow implements Predicate<CellTuple> {
        private final Player player;

        public PotentialTwoInARow(Player player) {
            this.player = player;
        }

        public boolean apply(CellTuple cellTuple) {
            return cellTuple.hasTwoEmptyCellsAnd(player);
        }
    }

    public static class IsFork implements Predicate<Cell> {
        private final Triples triples;
        private final Player player;

        public IsFork(Triples triples, Player player) {
            this.triples = triples;
            this.player = player;
        }

        public boolean apply(final Cell cell) {
            return triples.hasAtLeastTwoContainingCell(cell, new PotentialTwoInARow(player));
        }
    }

    public static class IsThreeInARow implements Predicate<CellTuple> {
        private final Player player;

        public IsThreeInARow(Player player) {
            this.player = player;
        }

        public boolean apply(CellTuple cellTuple) {
            return cellTuple.isAll(player);
        }
    }

    public static class AvailableThreeInARow implements Predicate<CellTuple> {
        private final Player player;

        public AvailableThreeInARow(Player player) {
            this.player = player;
        }

        public boolean apply(CellTuple cellTuple) {
            return cellTuple.hasEmptyCellAndTwo(player);
        }
    }

    public static class Contains implements Predicate<CellTuple> {
        private final Cell cell;

        public Contains(Cell cell) {
            this.cell = cell;
        }

        public boolean apply(CellTuple cellTuple) {
            return cellTuple.contains(cell);
        }
    }

    public static class MoveThatCanGo implements Predicate<Move> {
        private final Player player;

        public MoveThatCanGo(Player player) {
            this.player = player;
        }

        public boolean apply(Move move) {
            return move.canGo(player);
        }
    }
    public static class BelongingTo implements Predicate<Cell> {
        private final Player player;

        public BelongingTo(Player player) {
            this.player = player;
        }

        public boolean apply(Cell cell) {
            return cell.isMarkedBy(player);
        }
    }

}

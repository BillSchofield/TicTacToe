package org.bill.tictactoe.player;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.moves.*;

import java.util.List;

import static com.google.common.collect.Iterables.find;

public class AiStrategy extends Strategy {
    private Triples triples;
    private final List<Move> moves;

    public AiStrategy(Board board, Triples triples) {
        super(board);
        this.triples = triples;
        moves = new ImmutableList.Builder<Move>()
                .add(new ThreeInARowMove(triples))
                .add(new BlockMove(board, triples))
                .add(new ForkMove())
                .add(new BlockForkMove())
                .add(new PlayCenterMove(board))
                .add(new PlayOppositeCornerMove())
                .add(new RandomMove(board))
                .build();
    }

    public void go(final Player player) {
        find(moves, new MoveThatCanGo(player)).go(player);
    }

    private static class MoveThatCanGo implements Predicate<Move> {
        private final Player player;

        public MoveThatCanGo(Player player) {
            this.player = player;
        }

        public boolean apply(Move move) {
            return move.canGo(player);
        }
    }
}

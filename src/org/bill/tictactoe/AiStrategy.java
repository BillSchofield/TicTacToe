package org.bill.tictactoe;

import com.google.common.base.Nullable;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.util.Collections;
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
                .add(new BlockMove())
                .add(new ForkMove())
                .add(new BlockForkMove())
                .add(new PlayCenterMove())
                .add(new PlayOppositeCornerMove())
                .add(new RandomMove())
                .build();
    }

    public void go(final Mark mark) {
        find(moves, new MoveThatCanGo(mark)).go(board, mark);
    }

    private static class MoveThatCanGo implements Predicate<Move> {
        private final Mark mark;

        public MoveThatCanGo(Mark mark) {
            this.mark = mark;
        }

        public boolean apply(Move move) {
            return move.canGo(mark);
        }
    }
}

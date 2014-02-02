package org.bill.tictactoe.player;

import com.google.common.collect.ImmutableList;
import org.bill.tictactoe.board.Board;
import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.board.Triples;
import org.bill.tictactoe.moves.*;

import java.util.List;

import static com.google.common.collect.Iterables.find;
import static org.bill.tictactoe.Predicates.MoveThatCanGo;

public class AiStrategy implements Strategy {
    private final List<Move> movesBestToWorst;

    public AiStrategy(Board board, Triples triples) {
        movesBestToWorst = new ImmutableList.Builder<Move>()
                .add(new ThreeInARowMove(triples))
                .add(new BlockThreeInARowMove(triples))
                .add(new ForkMove(board, triples))
                .add(new BlockForkMove(new ForkMove(board, triples)))
                .add(new EmptyCellMove(board.center()))
                .add(new PlayOppositeCornerMove(triples))
                .add(new EmptyCellMove(board.corners()))
                .add(new EmptyCellMove(board.sides()))
                .build();
    }

    public Cell findMove(final Player player) {
        return find(movesBestToWorst, new MoveThatCanGo(player)).go(player);
    }
}

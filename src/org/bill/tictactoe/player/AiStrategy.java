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
    private final List<Move> moves;

    public AiStrategy(Board board, Triples triples) {
        moves = new ImmutableList.Builder<Move>()
                .add(new ThreeInARowMove(triples))
                .add(new BlockThreeInARowMove(triples))
                .add(new ForkMove(board, triples))
                .add(new BlockForkMove(new ForkMove(board, triples)))
                .add(new EmptyCellMove(board.center()))
                .add(new PlayOppositeCornerMove())
                .add(new EmptyCellMove(board.corners()))
                .add(new EmptyCellMove(board.sides()))
                .build();
    }

    public Cell findMove(final Player player) {
        return find(moves, new MoveThatCanGo(player)).go(player);
    }
}

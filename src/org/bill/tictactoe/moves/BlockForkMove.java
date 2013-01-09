package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.player.Player;

public class BlockForkMove implements Move {
    ForkMove forkMove;

    public BlockForkMove(ForkMove forkMove) {
        this.forkMove = forkMove;
    }

    public Cell go(Player player) {
        return forkMove.go(player.otherPlayer());
    }

    public boolean canGo(Player player) {
        return forkMove.canGo(player.otherPlayer());
    }
}

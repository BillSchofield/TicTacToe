package org.bill.tictactoe.moves;

import org.bill.tictactoe.board.Cell;
import org.bill.tictactoe.player.Player;

public interface Move {
    public Cell go(Player player);
    boolean canGo(Player player);
}

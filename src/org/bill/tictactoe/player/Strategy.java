package org.bill.tictactoe.player;

import org.bill.tictactoe.board.Cell;

public interface Strategy {
    public Cell findMove(Player player);
}

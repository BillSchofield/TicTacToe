package org.bill.tictactoe.moves;

import org.bill.tictactoe.player.Player;

public interface Move {
    public void go(Player player);
    boolean canGo(Player player);
}

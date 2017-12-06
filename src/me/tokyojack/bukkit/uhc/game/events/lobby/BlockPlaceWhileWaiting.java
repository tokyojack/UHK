package me.tokyojack.mcmarket.uhc.game.events.lobby;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.tokyojack.mcmarket.uhc.UHC;

public class BlockPlaceWhileWaiting implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void blockBreak(BlockBreakEvent event) {
		if (event.getPlayer().isOp())
			return;
		
		if (UHC.getPlugin().getGameManager().getGame().isIngame())
			return;
		
		event.setCancelled(true);
	}

}

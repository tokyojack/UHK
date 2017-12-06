package me.tokyojack.mcmarket.uhc.gamePlayer.events.score;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.EnderpearlThrowEvent;

public class EnderpearlThrow implements Listener {

	@EventHandler
	public void enderpearlThrow(EnderpearlThrowEvent event) {
		UHC.getPlugin().getGamePlayerManager().getGamePlayer(event.getPlayer().getName()).addEnderpearlThrown();
	}

}

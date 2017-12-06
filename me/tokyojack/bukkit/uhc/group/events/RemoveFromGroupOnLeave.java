package me.tokyojack.mcmarket.uhc.group.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.tokyojack.mcmarket.uhc.UHC;

//Change name to player quit?
public class RemoveFromGroupOnLeave implements Listener {

	@EventHandler
	public void playerLeave(PlayerQuitEvent event){
		UHC.getPlugin().getGroupManager().removePlayerFromGroup(event.getPlayer().getName());
	}
	
}

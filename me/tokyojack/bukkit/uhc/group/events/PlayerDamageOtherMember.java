package me.tokyojack.mcmarket.uhc.group.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerDamagePlayerEvent;

public class PlayerDamageOtherMember implements Listener {

	@EventHandler
	public void playerDamagePlayer(PlayerDamagePlayerEvent event) {
		Player damager = event.getDamager();

		if (!UHC.getPlugin().getGroupManager().isInSameGroup(event.getVictim().getName(), damager.getName()))
			return;

		damager.sendMessage(Chat.color("&cbad boi"));
		event.setCancelled(true);
	}
}

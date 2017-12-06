package me.tokyojack.mcmarket.uhc.group.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerShootPlayerEvent;

public class PlayerShootOtherMember implements Listener {

	@EventHandler
	public void playerDamagePlayer(PlayerShootPlayerEvent event) {
		Player victim = event.getVictim();
		Player damager = event.getDamager();

		if (UHC.getPlugin().getGroupManager().isInSameGroup(victim.getName(), damager.getName())) {
			damager.sendMessage(Chat.color("&cbad boi"));
			event.setCancelled(true);
		}
	}

}

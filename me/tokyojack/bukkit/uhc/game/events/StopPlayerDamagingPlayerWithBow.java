package me.tokyojack.mcmarket.uhc.game.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.game.objects.BlockedDamage;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerShootPlayerEvent;

public class StopPlayerDamagingPlayerWithBow implements Listener {

	@EventHandler
	public void playerDamagePlayer(PlayerShootPlayerEvent event) {
		if (UHC.getPlugin().getGameManager().getGame().getDamageTakenType() != BlockedDamage.PLAYER)
			return;

		event.getDamager().sendMessage("Grace period");
		event.getProjectile().remove();
		event.setCancelled(true);
	}

}
